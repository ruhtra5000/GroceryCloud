package br.com.grocerycloud.grocerycloud.negocio.entidade;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/** 
 * Esta classe representa a compra de produtos por parte 
 * do supermercado, visando reabastecer o estoque.
 * @author Arthur de Sá Tenório
 * @category Entidade básica da aplicação
*/

@Entity
public class Aquisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dataAquisicao;
    private String cnpjFornecedor;

    @ManyToOne
    private Produto produto;

    private int qtdeProduto;
    private double custo;

    public Aquisicao(){}

    public Aquisicao(Date dataAquisicao, String cnpjFornecedor, Produto produto, int qtdeProduto, double custo) {
        this.dataAquisicao = dataAquisicao;
        this.cnpjFornecedor = cnpjFornecedor;
        this.produto = produto;
        this.qtdeProduto = qtdeProduto;
        this.custo = custo;
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getDataAquisicao() {
        return this.dataAquisicao;
    }
    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getCnpjFornecedor() {
        return this.cnpjFornecedor;
    }
    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public Produto getProduto() {
        return this.produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdeProduto() {
        return this.qtdeProduto;
    }
    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public double getCusto() {
        return this.custo;
    }
    public void setCusto(double custo) {
        this.custo = custo;
    }

}
