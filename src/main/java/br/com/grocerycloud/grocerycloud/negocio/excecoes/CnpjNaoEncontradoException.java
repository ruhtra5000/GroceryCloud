package br.com.grocerycloud.grocerycloud.negocio.excecoes;

/** 
 * @author Arthur de Sá Tenório
 * @category Classe de exceção da aplicação
*/

public class CnpjNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public CnpjNaoEncontradoException(){
        super("Não há aquisições relacionadas a este CNPJ.");
    }
}
