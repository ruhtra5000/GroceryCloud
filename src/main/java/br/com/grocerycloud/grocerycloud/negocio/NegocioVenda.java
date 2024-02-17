package br.com.grocerycloud.grocerycloud.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.InterfaceRepositorioVenda;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Funcionario;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Venda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.UsuarioSemVendasException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.VendaNaoEncontradaException;

/** 
 * Esta classe implementa as ações e as regras de negocio relacionadas a uma venda
 * @author Arthur de Sá Tenório
 * @category Classe de negocio da aplicação
*/

@Service
public class NegocioVenda implements IColecaoVenda {
    @Autowired
    private InterfaceRepositorioVenda repositorioVenda;

    @Override
    public void adicionar(Venda venda) { //Atualizar o estoque
        repositorioVenda.save(venda);
    }

    @Override
    public List<Venda> listarTodos() {
        return repositorioVenda.findAll();
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
