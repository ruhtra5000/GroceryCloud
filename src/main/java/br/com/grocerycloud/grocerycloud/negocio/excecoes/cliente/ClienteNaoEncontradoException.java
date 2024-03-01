package br.com.grocerycloud.grocerycloud.negocio.excecoes.cliente;

/**
 * @author João Victor Leite Dos Santos
 * @category Classe de exceção de Cliente
 */
public class ClienteNaoEncontradoException extends Exception {

    private static final long serialVersionUID = 1L;

    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado!");
    }

}