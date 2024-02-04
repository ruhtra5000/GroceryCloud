package br.com.grocerycloud.grocerycloud.negocio.entidade;

import jakarta.persistence.Entity;

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
