package br.com.grocerycloud.grocerycloud.controlador.dto;

/** 
 * Esta classe representa os dados da requisição de abrir uma venda.
 * @author Arthur de Sá Tenório
 * @category Classe de DTO da aplicação
*/

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
