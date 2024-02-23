package br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos;

/** 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de exceção da aplicação
*/
public class ProdutoNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProdutoNaoEncontradoException() {
		super("Produto não encontrado!");
	}
	
}