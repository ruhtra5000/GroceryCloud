package br.com.grocerycloud.grocerycloud.negocio.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/** 
 * Esta classe representa um produto de qualquer natureza
 * que será comercializado através do Grocery Cloud.
 * @author Guilherme Paes Cavalcanti
 * @category Entidade básica da aplicação
*/

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String categoria;
    private int qtdeEstoque;
    private double preco;
    private double precoDesconto;

    public Produto(){}

    public Produto(String nome, String categoria, int qtdeEstoque, double preco, double precoDesconto) {
        this.nome = nome;
        this.categoria = categoria;
        this.qtdeEstoque = qtdeEstoque;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return this.categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQtdeEstoque() {
        return this.qtdeEstoque;
    }
    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoDesconto() {
        return this.precoDesconto;
    }
    public void setPrecoDesconto(double precoDesconto) {
        this.precoDesconto = precoDesconto;
    }
}
