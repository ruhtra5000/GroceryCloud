package br.com.grocerycloud.grocerycloud.controlador.dto;

import java.util.Date;

/**
 * Classe que representa os dados da requisição para registrar um produto.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de DTO da aplicação
 */

public class RequisicaoRegistrarProdutoAvariado {

    private long id;
    private int qtdeAvariados;
    private Date dataAvariado;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQtdeAvariados() {
        return this.qtdeAvariados;
    }

    public void setQtdeAvariados(int qtdeAvariados) {
        this.qtdeAvariados = qtdeAvariados;
    }

    public Date getDataAvariado() {
        return this.dataAvariado;
    }

    public void setDataAvariado(Date dataAvariado) {
        this.dataAvariado = dataAvariado;
    }

}
