package br.com.grocerycloud.grocerycloud.controlador.dto;

public class RequisicaoLogin {
    private String cpf;
    private String senha;

    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return this.senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
