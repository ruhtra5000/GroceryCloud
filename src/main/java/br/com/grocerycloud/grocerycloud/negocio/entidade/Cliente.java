package br.com.grocerycloud.grocerycloud.negocio.entidade;

import jakarta.persistence.Entity;


/** 
 * Esta classe representa um Cliente
 * que acessa o Grocery Cloud.
 * @author João Victor Leite Dos Santos
 * @category Entidade básica da aplicação
*/

@Entity
public class Cliente extends Usuario {
    private boolean vinculo;
    private boolean contaAtiva;

    public boolean getVinculo() {
        return this.vinculo;
    }
    public void setVinculo(boolean vinculo) {
        this.vinculo = vinculo;
    }

    public boolean getContaAtiva() {
        return this.contaAtiva;
    }
    public void setContaAtiva(boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
    }

}
