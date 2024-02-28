package br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos;

/**
 * @author Guilherme Paes Cavalcanti
 * @category Classe de exceção da aplicação
 */
public class AvariadoNaoEncontradoException extends Exception {

    private static final long serialVersionUID = 1L;

    public AvariadoNaoEncontradoException() {
        super("Produto avariado não encontrado!");
    }

}