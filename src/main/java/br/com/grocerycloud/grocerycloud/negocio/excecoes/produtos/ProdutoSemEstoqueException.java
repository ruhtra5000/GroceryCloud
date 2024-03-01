package br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos;

/** 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de exceção da aplicação
*/
public class ProdutoSemEstoqueException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProdutoSemEstoqueException() {
		super("O produto está fora de estoque!");
	}
	
}
