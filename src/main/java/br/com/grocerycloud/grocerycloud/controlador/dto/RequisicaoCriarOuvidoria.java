package br.com.grocerycloud.grocerycloud.controlador.dto;

/** 
 * Esta classe representa os dados da requisição de iniciar uma ouvidoria.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de DTO da aplicação
*/

public class RequisicaoCriarOuvidoria {

    private long id;
    private String mensagem;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
