package br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios;

/** 
 * @author Arthur de Sá Tenório
 * @category Classe de exceção da aplicação
*/
public class FuncionarioDuplicadoException extends Exception {
    private static final long serialVersionUID = 1L;

    public FuncionarioDuplicadoException(){
        super("O CPF informado já se encontra cadastrado.");
    }
}
