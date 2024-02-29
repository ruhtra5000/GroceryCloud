package br.com.grocerycloud.grocerycloud.negocio.entidade;

import jakarta.persistence.Entity;

/** 
 * Esta classe representa um colaborador contratado
 * pela empresa que faz uso do Grocery Cloud.
 * @author Victor Cauã Tavares Inácio
 * @category Entidade básica da aplicação
*/

@Entity
public class Funcionario extends Usuario{
    private String email;
    private String telefone;
    private int tipoAcesso;

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipoAcesso() {
        return this.tipoAcesso;
    }
    public void setTipoAcesso(int tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

}
