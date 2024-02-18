package br.com.grocerycloud.grocerycloud.negocio.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/** 
 * Esta classe representa um produto que foi vendido, o qual
 * faz parte de uma Venda.
 * @author Arthur de Sá Tenório
 * @category Entidade básica da aplicação
*/

@Entity
public class ProdutoVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Produto produto;
    
    private int quantidade;
    private double valorUnit;

    public ProdutoVenda(){}

    public ProdutoVenda(Produto produto, int quantidade, double valorUnit) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnit = valorUnit;
    }
    
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return this.produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnit() {
        return this.valorUnit;
    }
    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }

    @Override
    public boolean equals(Object obj) {
        //No contexto de uma venda, é provável que o produtoVenda ainda não tenha um ID,
        //portanto, o produtoVenda é igual a outro se, e somente se, o id do produto o qual ele
        //se refere já pode ser encontrado no "carrinho"
        if(obj instanceof ProdutoVenda)
            return (this.produto.getId() == ((ProdutoVenda)obj).getProduto().getId());
        return false;
    }
}
