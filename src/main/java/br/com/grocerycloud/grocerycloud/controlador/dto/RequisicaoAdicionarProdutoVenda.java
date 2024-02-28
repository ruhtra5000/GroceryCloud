package br.com.grocerycloud.grocerycloud.controlador.dto;

/** 
 * Esta classe representa os dados da requisição de adicionar um produto numa venda.
 * @author Arthur de Sá Tenório
 * @category Classe de DTO da aplicação
*/

public class RequisicaoAdicionarProdutoVenda {
    private long id;
    private int quantidade;

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
