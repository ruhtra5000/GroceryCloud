package br.com.grocerycloud.grocerycloud.negocio.fachada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoCliente;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoFuncionario;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProduto;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Venda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.ProdutoInsuficienteException;

/** 
 * Esta classe representa a fachada que será utilizada pelos operadores de caixa.
 * @author Arthur de Sá Tenório
 * @category Classe de fachada da aplicação
*/

@Service
public class FachadaCaixa {
    @Autowired
    private IColecaoProduto colecaoProduto;
    @Autowired
    private IColecaoVenda colecaoVenda;
    @Autowired
    private IColecaoProdutoVenda colecaoProdutoVenda;
    @Autowired
    private IColecaoCliente colecaoCliente;
    @Autowired
    private IColecaoFuncionario colecaoFuncionario;

    //Armazena (temporariamente) a venda que está sendo executada.
    private Venda vendaTemporaria;
    
    public void abrirVenda(String cpfFuncionario, String cpfCliente) throws CpfNaoEncontradoException{ //INCOMPLETO
        Funcionario funcionario = colecaoFuncionario.listarPorCpf(cpfFuncionario);
        Cliente cliente = colecaoCliente.listarPorCpf(cpfCliente);
        
        //Caso os usuarios em questão sejam encontrados:
            vendaTemporaria = new Venda();
            vendaTemporaria.setDataVenda(new Date());
            vendaTemporaria.setCliente(cliente); 
            vendaTemporaria.setFuncionario(funcionario);
            vendaTemporaria.setProdutosVenda(new ArrayList<>(Arrays.asList()));
            vendaTemporaria.setValorTotal(0);
    }

    public List<ProdutoVenda> listarProdutosVenda(){
        return colecaoVenda.listarProdutosVenda(vendaTemporaria);
    }

    public void adicionarProdutoVenda(long idProduto, int quantidade) throws ProdutoNaoEncontradoException, ProdutoInsuficienteException{
        Produto prod = colecaoProduto.listarPorId(idProduto);
        
        //Caso o produto em questão esteja na lista, atualiza-se sua quantidade
        int indice = checarProdutoVendaExiste(idProduto, vendaTemporaria.getProdutosVenda());
        if(indice != -1){
            int qtdeVenda = vendaTemporaria.getProdutosVenda().get(indice).getQuantidade();
            //Checando se há quantidade suficiente em estoque
            if(checarQuantidadeProdutoEstoque(prod.getQtdeEstoque(), qtdeVenda + quantidade)){
                vendaTemporaria.getProdutosVenda().get(indice).setQuantidade(qtdeVenda + quantidade);
                colecaoVenda.calcularValorTotal(vendaTemporaria);
            }
            else 
                throw new ProdutoInsuficienteException();
        }
        //Caso contrario, adiciona-o na venda
        else {
            //Checando se há quantidade suficiente em estoque
            if(checarQuantidadeProdutoEstoque(prod.getQtdeEstoque(), quantidade)){
                ProdutoVenda produtoVenda = new ProdutoVenda(prod, quantidade, 0);
                if(prod.getPrecoDesconto() != -1)
                    produtoVenda.setValorUnit(prod.getPrecoDesconto());
                else 
                    produtoVenda.setValorUnit(prod.getPreco());
                colecaoVenda.adicionarProdutoVenda(vendaTemporaria, produtoVenda);
                colecaoVenda.calcularValorTotal(vendaTemporaria);
            }
            else 
                throw new ProdutoInsuficienteException();
        }
    }

    public void removerProdutoVenda(long idProduto) throws ProdutoNaoEncontradoException{
        colecaoVenda.removerProdutoVenda(vendaTemporaria, idProduto);
        colecaoVenda.calcularValorTotal(vendaTemporaria);
    }

    public void fecharVenda() throws ProdutoNaoEncontradoException{ 
        Produto p;
        for(var elem : vendaTemporaria.getProdutosVenda()){
            colecaoProdutoVenda.adicionar(elem);
            
            //Atualizando o estoque
            p = elem.getProduto();
            p.setQtdeEstoque(p.getQtdeEstoque() - elem.getQuantidade());
            colecaoProduto.atualizar(p.getId(), p.getNome(), p.getCategoria(), p.getQtdeEstoque(),
            p.getPreco(), p.getPrecoDesconto());
        }

        //Dar desconto, caso o cliente seja vinculado ao supermercado
        if(vendaTemporaria.getCliente().getVinculo()){
            colecaoVenda.darDescontoVinculo(vendaTemporaria);
        }
        colecaoVenda.adicionar(vendaTemporaria);
        vendaTemporaria = null;
    }

    public void cancelarVenda(){
        vendaTemporaria = null;
    }

    public double retornarValorTotal(){
        return vendaTemporaria.getValorTotal();
    }

    //Retorna o indice do elemento, caso exista
    private int checarProdutoVendaExiste(long id, List<ProdutoVenda> lista){
        if(lista == null)
            return -1;
        
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getProduto().getId() == id)
                return i;
        }
        return -1;
    }

    //Retorna true caso hajam produtos suficientes no estoque, false caso contrario
    private boolean checarQuantidadeProdutoEstoque(int qtdeEstoque, int qtdeDesejada){
        return (qtdeEstoque >= qtdeDesejada);
    }
}
