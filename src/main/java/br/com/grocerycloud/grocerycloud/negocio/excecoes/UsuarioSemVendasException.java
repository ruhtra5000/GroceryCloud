package br.com.grocerycloud.grocerycloud.negocio.excecoes;

/** 
 * @author Arthur de Sá Tenório
 * @category Classe de exceção da aplicação
*/

public class UsuarioSemVendasException extends Exception {
    private static final long serialVersionUID = 1L;

    public UsuarioSemVendasException(){
        super("Não há vendas relacionadas a este usuário.");
    }
}
