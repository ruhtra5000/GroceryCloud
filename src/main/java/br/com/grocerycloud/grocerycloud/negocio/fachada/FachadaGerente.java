package br.com.grocerycloud.grocerycloud.negocio.fachada;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;

/** 
 * Esta classe representa a fachada que será utilizada pelos gerentes.
 * @author Arthur de Sá Tenório
 * @category Classe de fachada da aplicação
*/

@Service
public class FachadaGerente {
    @Autowired
    private IColecaoVenda colecaoVenda;
    @Autowired
    private IColecaoAquisicao colecaoAquisicao;
    //NECESSARIO COLECAO DE PRODUTOS, USUARIOS, TROCAS, QUASE TUDO

    //VENDAS

    //AQUISIÇÕES
    public void adicionarAquisicao(Date dataAquisicao, String cnpjFornecedor,
                                   long idProduto, int qtdeProduto, double custo){
        Produto produto; //= buscarProduto(id);
        Aquisicao aquisicao = new Aquisicao(dataAquisicao, cnpjFornecedor, produto, qtdeProduto, custo);
        colecaoAquisicao.adicionar(aquisicao);
        //ATUALIZAR ESTOQUE
    }
}
