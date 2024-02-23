package br.com.grocerycloud.grocerycloud.negocio.entidade;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProdutoAvariado extends Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvariado;
    private int qtdeAvariados;
    private Date dataAvariado;
    
    public ProdutoAvariado(Produto produto, int qtdeAvariados, Date dataAvariado){
    	super(produto.getNome(), produto.getCategoria(), produto.getQtdeEstoque(),produto.getPreco(), produto.getPrecoDesconto());
    	this.qtdeAvariados = qtdeAvariados;
    	this.dataAvariado = dataAvariado;
    }
    
	public long getIdAvariado() {
		return idAvariado;
	}
	public void setIdAvariado(long idAvariado) {
		this.idAvariado = idAvariado;
	}
	
	public int getQtdeAvariados() {
		return qtdeAvariados;
	}
	public void setQtdeAvariados(int qtdeAvariados) {
		this.qtdeAvariados = qtdeAvariados;
	}

	public Date getDataAvariado() {
		return dataAvariado;
	}
	public void setDataAvariado(Date dataAvariado) {
		this.dataAvariado = dataAvariado;
	}
    
    
	
}
