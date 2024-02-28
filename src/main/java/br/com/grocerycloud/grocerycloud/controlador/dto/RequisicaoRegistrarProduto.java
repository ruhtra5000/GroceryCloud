package br.com.grocerycloud.grocerycloud.controlador.dto;

/**
 * Classe que representa os dados da requisição para registrar um produto.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de DTO da aplicação
 */

public class RequisicaoRegistrarProduto {

    private long id;
    private String nome;
    private String categoria;
    private int qtde;
    private double preco;
    private double precoDesconto;

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

    public int getQtde() {
        return this.qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
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
