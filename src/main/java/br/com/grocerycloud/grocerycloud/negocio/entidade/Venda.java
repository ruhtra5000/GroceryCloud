package br.com.grocerycloud.grocerycloud.negocio.entidade;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/** 
 * Esta classe representa uma venda e todos os dados que a tangem.
 * @author Arthur de Sá Tenório
 * @category Entidade básica da aplicação
*/

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dataVenda;
    private double valorTotal;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Funcionario funcionario;
    
    @OneToMany(targetEntity = ProdutoVenda.class)
    @JoinColumn(name = "produto_venda")
    private List<ProdutoVenda> produtosVenda;

    public Venda(){}

    public Venda(Date dataVenda, double valorTotal, Cliente cliente, Funcionario funcionario, List<ProdutoVenda> produtosVenda) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.produtosVenda = produtosVenda;
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return this.dataVenda;
    }
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<ProdutoVenda> getProdutosVenda() {
        return this.produtosVenda;
    }
    public void setProdutosVenda(List<ProdutoVenda> produtosVenda) {
        this.produtosVenda = produtosVenda;
    }
}
