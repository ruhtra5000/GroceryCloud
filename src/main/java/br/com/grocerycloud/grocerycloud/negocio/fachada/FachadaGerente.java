package br.com.grocerycloud.grocerycloud.negocio.fachada;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.AquisicaoNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.CnpjNaoEncontradoException;

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
        //Aquisicao aquisicao = new Aquisicao(dataAquisicao, cnpjFornecedor, produto, qtdeProduto, custo);
        //colecaoAquisicao.adicionar(aquisicao);
        //ATUALIZAR ESTOQUE
    }

    public List<Aquisicao> listarAquisicoes(){
        return colecaoAquisicao.listarTodos();
    }

    public Aquisicao buscarAquisicaoPorId(long id) throws AquisicaoNaoEncontradaException{
        return colecaoAquisicao.listarPorId(id);
    }

    public List<Aquisicao> buscarAquisicaoPorCnpj(String cnpj) throws CnpjNaoEncontradoException {
        return colecaoAquisicao.listarPorCNPJ(cnpj);
    }
}
