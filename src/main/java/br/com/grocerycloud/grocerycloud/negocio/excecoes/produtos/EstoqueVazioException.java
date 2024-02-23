package br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos;

/** 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de exceção da aplicação
*/
public class EstoqueVazioException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EstoqueVazioException() {
		super("Não há produtos em estoque!");
	}
}
