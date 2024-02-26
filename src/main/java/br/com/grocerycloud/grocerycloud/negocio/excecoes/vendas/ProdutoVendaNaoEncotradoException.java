package br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas;

/** 
 * @author Arthur de Sá Tenório
 * @category Classe de exceção da aplicação
*/

public class ProdutoVendaNaoEncotradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public ProdutoVendaNaoEncotradoException(){
        super("ProdutoVenda não encontrado.");
    }
}
