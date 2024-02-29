package br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes;

/** 
 * @author Arthur de Sá Tenório
 * @category Classe de exceção da aplicação
*/

public class CnpjInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;

    public CnpjInvalidoException(){
        super("O CNPJ informado é inválido."); 
    }
}
