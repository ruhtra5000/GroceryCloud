package br.com.grocerycloud.grocerycloud.negocio.entidade;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/** 
 * Esta classe representa um produto que foi avariado.
 * @author Guilherme Paes Cavalcanti
 * @category Entidade básica da aplicação
*/

@Entity
public class ProdutoAvariado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Produto produto;


	private int qtdeAvariados;
	private Date dataAvariado;

	public ProdutoAvariado() {

	}

	public ProdutoAvariado(Produto produto, int qtdeAvariados, Date dataAvariado) {
		this.produto = produto;
		this.qtdeAvariados = qtdeAvariados;
		this.dataAvariado = dataAvariado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
