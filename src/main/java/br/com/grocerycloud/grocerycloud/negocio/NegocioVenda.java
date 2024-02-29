package br.com.grocerycloud.grocerycloud.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioVenda;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Funcionario;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Venda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.UsuarioSemVendasException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.VendaNaoEncontradaException;

/** 
 * Esta classe implementa as ações e as regras de negocio relacionadas a uma venda
 * @author Arthur de Sá Tenório
 * @category Classe de negocio da aplicação
*/

@Service
public class NegocioVenda implements IColecaoVenda {
    @Autowired
    private IRepositorioVenda repositorioVenda;
    
    //Criação de uma venda
    @Override
    public void adicionar(Venda venda) { 
        repositorioVenda.save(venda);
    }

    @Override
    public void adicionarProdutoVenda(Venda venda, ProdutoVenda produtoVenda) {
        venda.getProdutosVenda().add(produtoVenda);
    }

    @Override
    public void removerProdutoVenda(Venda venda, long idProduto) throws ProdutoNaoEncontradoException {
        for(int i = 0; i < venda.getProdutosVenda().size(); i++){
            if(venda.getProdutosVenda().get(i).getProduto().getId() == idProduto){
                venda.getProdutosVenda().remove(i);
                return;
            }
        }
        throw new ProdutoNaoEncontradoException();
    }

    @Override
    public List<ProdutoVenda> listarProdutosVenda(Venda venda){
        return venda.getProdutosVenda();
    }

    @Override
    public void calcularValorTotal(Venda venda) {
        double valorTotal = 0;
        for(var i : venda.getProdutosVenda()){
            valorTotal += (i.getValorUnit()*i.getQuantidade());
        }
        
        venda.setValorTotal(valorTotal);
    }

    //Listagens de venda. Não estão ligados a criação de uma venda.
    @Override
    public List<Venda> listarTodos() {
        return repositorioVenda.findAllByOrderById();
    }

    @Override
    public Venda listarPorId(long id) throws VendaNaoEncontradaException {
        Venda venda = repositorioVenda.findById(id);
        if(venda == null)
            throw new VendaNaoEncontradaException();
        return venda;
    }

    @Override
    public List<Venda> listarPorCliente(Cliente cliente) throws UsuarioSemVendasException {
        List<Venda> vendas = repositorioVenda.findAllByCliente(cliente);
        if(vendas.isEmpty())
            throw new UsuarioSemVendasException();
        return vendas;
    }

    @Override
    public List<Venda> listarPorFuncionario(Funcionario funcionario) throws UsuarioSemVendasException {
        List<Venda> vendas = repositorioVenda.findAllByFuncionario(funcionario);
        if(vendas.isEmpty())
            throw new UsuarioSemVendasException();
        return vendas;
    }
}
