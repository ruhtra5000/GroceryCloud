package br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios;

/** 
 * @author Victor Caua Tavares Inacio
 * @category Classe de exceção de funcionario
*/
public class NomeFuncionarioNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NomeFuncionarioNaoEncontradoException() {

		super("Nome do funcionario não encontrado!");
	}
	
}