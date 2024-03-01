package br.com.grocerycloud.grocerycloud.negocio.excecoes.cliente;

/**
 * @author João Victor Leite Dos Santos
 * @category Classe de exceção de funcionario
 */
public class NomeClienteNaoEncontradoException extends Exception {

    private static final long serialVersionUID = 1L;

    public NomeClienteNaoEncontradoException() {

        super("Nome do Cliente não encontrado!");
    }

}