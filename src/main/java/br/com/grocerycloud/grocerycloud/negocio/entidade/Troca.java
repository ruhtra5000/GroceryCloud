package br.com.grocerycloud.grocerycloud.negocio.entidade;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/** 
 * Esta classe representa a troca de um produto que foi avariado.
 * @author João Victor Leite Dos Santos
 * @category Entidade básica da aplicação
*/

@Entity
public class Troca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private ProdutoAvariado produtoAvariado;

    private Date dataTroca;

    public Troca(ProdutoAvariado produtoAvariado,Date date){
        this.produtoAvariado = produtoAvariado;
        this.dataTroca = date;
    }

    public ProdutoAvariado getProdutoAvariado() {
        return produtoAvariado;
    }

    public Date getDataTroca() {
        return dataTroca;
    }

    public long getId() {
        return id;
    }

    public void setProdutoAvariado(ProdutoAvariado produtoAvariado) {
        this.produtoAvariado = produtoAvariado;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataTroca(Date dataTroca) {
        this.dataTroca = dataTroca;
    }
}
