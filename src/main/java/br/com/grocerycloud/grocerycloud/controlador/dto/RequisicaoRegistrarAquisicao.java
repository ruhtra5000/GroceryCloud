package br.com.grocerycloud.grocerycloud.controlador.dto;

/** 
 * Esta classe representa os dados da requisição de registrar uma aquisição.
 * @author Arthur de Sá Tenório
 * @category Classe de DTO da aplicação
*/

public class RequisicaoRegistrarAquisicao {
    private String cnpjFornecedor;
    private long idProduto;
    private int qtdeProduto;
    private double custo;
    private String dataAquisicao;

    public String getCnpjFornecedor() {
        return this.cnpjFornecedor;
    }
    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public long getIdProduto() {
        return this.idProduto;
    }
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdeProduto() {
        return this.qtdeProduto;
    }
    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public double getCusto() {
        return this.custo;
    }
    public void setCusto(double custo) {
        this.custo = custo;
    }

    public String getDataAquisicao() {
        return this.dataAquisicao;
    }
    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

}
