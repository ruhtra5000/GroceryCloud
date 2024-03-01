package br.com.grocerycloud.grocerycloud.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.negocio.NegocioVenda;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoCliente;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoFuncionario;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoOuvidoria;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProduto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Ouvidoria;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Usuario;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Venda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.login.UsuarioNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.cliente.ClienteNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.UsuarioSemVendasException;

/**
 * Esta classe representa a fachada que será utilizada pelos clientes.
 * 
 * @author Victor Cauã Tavares Inácio
 * @category Classe de fachada da aplicação
 */

@Service
public class FachadaCliente {
    @Autowired
    private IColecaoProduto colecaoProduto;
    @Autowired
    private IColecaoOuvidoria colecaoOuvidoria;
    @Autowired
    private IColecaoCliente colecaoCliente;
    @Autowired
    private IColecaoFuncionario colecaoFuncionario;
    @Autowired
    private NegocioVenda colecaoVenda;

    /**
     * Método que realiza o login.
     * 
     * @author Arthur de Sá Tenório
     */
    public Usuario buscarUsuario(String cpf, String senha) throws UsuarioNaoEncontradoException {
        //Buscando funcionario
        Usuario usuario = colecaoFuncionario.buscarPorCpfESenha(cpf, senha);
        if (usuario != null) {
            return usuario;
        }

        //Buscando cliente
        usuario = colecaoCliente.buscarPorCpfESenha(cpf, senha);
        if(usuario != null){
            return usuario;
        }
        throw new UsuarioNaoEncontradoException();
    }

    /** 
     * Método que lista os produtos em promoção.
     * @author Arthur de Sá Tenório
     */
    public List<Produto> buscarProdutosComDesconto() {
        return colecaoProduto.listarPorDesconto();
    }

    
     /** 
     * Métodos que tangem a ouvidoria, na fachada do cliente.
     * 
     * @author Victor Cauã Tavares Inácio
    */
    //OUVIDORIA

    public void criarOuvidoria(long id, String mensagem) throws ClienteNaoEncontradoException{ 

        Cliente cliente = colecaoCliente.listarPorId(id);
        if(cliente != null){
            Ouvidoria ouvidoria = new Ouvidoria(id, cliente, mensagem);
            colecaoOuvidoria.adicionar(ouvidoria);           }
        else{
            throw new ClienteNaoEncontradoException();
        }
    }

    /** 
     * Métodos que tangem a visualização de historico e atualização de vinculo, na fachada do cliente.
     * @author João Victor Leite Dos Santos
    */
    public List<Venda> visualizarHistoricoDeCompras(String cpf) throws CpfNaoEncontradoException, UsuarioSemVendasException {
        Cliente cliente = colecaoCliente.listarPorCpf(cpf);
        List<Venda> lista = colecaoVenda.listarPorCliente(cliente);
        if (lista.isEmpty()) 
            throw new UsuarioSemVendasException();
        return lista;
    }

    public void atualizarVinculo(String cpf) throws CpfNaoEncontradoException, ClienteNaoEncontradoException {
        Cliente cliente = colecaoCliente.listarPorCpf(cpf);
        if (cliente == null) 
            throw new CpfNaoEncontradoException();
        
        if(cliente.getVinculo() == true){
            cliente.setVinculo(false);
        }
        else {
            cliente.setVinculo(true);
        }

        colecaoCliente.atualizar(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getSenha(), cliente.getVinculo());
    }
}

