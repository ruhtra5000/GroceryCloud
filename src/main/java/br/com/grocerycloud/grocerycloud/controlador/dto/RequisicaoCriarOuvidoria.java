package br.com.grocerycloud.grocerycloud.controlador.dto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;

/** 
 * Esta classe representa os dados da requisição de iniciar uma ouvidoria.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de DTO da aplicação
*/

public class RequisicaoCriarOuvidoria {

    private long id;
    private Cliente cliente;
    private String mensagem;

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
