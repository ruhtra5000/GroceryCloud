package br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos;

/** 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de exceção da aplicação
*/
public class CategoriaNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CategoriaNaoEncontradaException() {
		super("Nenhum produto relacionado a esta categoria!");
	}
	
}
