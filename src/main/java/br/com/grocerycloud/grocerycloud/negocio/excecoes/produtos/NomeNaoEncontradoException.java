package br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos;

/** 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de exceção da aplicação
*/
public class NomeNaoEncontradoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NomeNaoEncontradoException() {
		super("Nenhum produto relacionado a este nome!");
	}

}
