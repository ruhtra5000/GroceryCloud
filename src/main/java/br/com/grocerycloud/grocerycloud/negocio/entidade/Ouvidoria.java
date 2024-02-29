package br.com.grocerycloud.grocerycloud.negocio.entidade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/** 
 * Esta classe representa uma instância de uso da ouvidoria,
 * a qual contem uma mensagem para os adminstradores do negócio. 
 * @author Victor Cauã Tavares Inácio
 * @category Entidade básica da aplicação
*/

@Entity
public class Ouvidoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Cliente cliente;
    private String mensagem;
    

    public Ouvidoria() {
    }
    
    public Ouvidoria(long id, Cliente cliente, String mensagem) {
        this.id = id;
        this.cliente = cliente;
        this.mensagem = mensagem;
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensagem() {
        return this.mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
