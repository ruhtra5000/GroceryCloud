package br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos;

/**
 * @author Guilherme Paes Cavalcanti
 * @category Classe de exceção da aplicação
 */
public class QuantidadeProdutoInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;

	public QuantidadeProdutoInsuficienteException() {
		super("A quantidade inserida é maior que a quantidade em estoque!");
	}

}
