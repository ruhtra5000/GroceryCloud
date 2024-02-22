package br.com.grocerycloud.grocerycloud.controlador.dto;

public class RequisicaoAbrirVenda {
    private String cpfCliente;
    private String cpfFuncionario;

    public String getCpfCliente() {
        return this.cpfCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCpfFuncionario() {
        return this.cpfFuncionario;
    }
    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }
    
}
