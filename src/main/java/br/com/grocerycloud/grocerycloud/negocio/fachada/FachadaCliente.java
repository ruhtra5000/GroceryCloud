package br.com.grocerycloud.grocerycloud.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoFuncionario;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProduto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Usuario;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.login.UsuarioNaoEncontradoException;

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

    // @Autowired
    // private IColecaoOuvidoria colecaoOuvidoria;

    @Autowired
    private IColecaoFuncionario colecaoFuncionario;

    /**
     * Método que realiza o login.
     * 
     * @author Arthur de Sá Tenório
     */
    public Usuario buscarUsuario(String cpf, String senha) throws UsuarioNaoEncontradoException {
        Usuario usuario = colecaoFuncionario.buscarPorCpfESenha(cpf, senha);
        if (usuario != null) {
            return usuario;
        }

        // usuario = colecaoCliente.buscarPorCpfESenha(cpf, senha);
        // if(usuario != null){
        // return usuario; //INCOMPLETO
        // }
        throw new UsuarioNaoEncontradoException();
    }

    /**
     * Métodos relacionados aos produtos em promoção.
     * 
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

    // OUVIDORIA
    public void adicionarOuvidoria(long Idcliente, String mensagem) { // INCOMPLETO

    }

}
