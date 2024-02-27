package br.com.grocerycloud.grocerycloud.negocio.excecoes.login;

/** 
 * @author Arthur de Sá Tenório
 * @category Classe de exceção da aplicação
*/

public class UsuarioNaoEncontradoException extends Exception{
    private static final long serialVersionUID = 1L;
	
	public UsuarioNaoEncontradoException() {
		super("CPF ou senha incorretos!");
	}
}
