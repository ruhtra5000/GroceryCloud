package br.com.grocerycloud.grocerycloud.negocio.fachada;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProduto;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Venda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.AquisicaoNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.EstoqueVazioException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.VendaNaoEncontradaException;

/** 
 * Esta classe representa a fachada que será utilizada pelos gerentes.
 * @author Arthur de Sá Tenório
 * @category Classe de fachada da aplicação
*/

@Service
public class FachadaGerente {
    @Autowired
    private IColecaoProduto colecaoProduto;
    @Autowired
    private IColecaoVenda colecaoVenda;
    @Autowired
    private IColecaoAquisicao colecaoAquisicao;

    //PRODUTOS
    public List<Produto> listarProdutos() throws EstoqueVazioException{
        return colecaoProduto.listarTodos();
    }

    public Produto listarProdutoPorId(long id) throws ProdutoNaoEncontradoException{
        return colecaoProduto.listarPorId(id);
    }

    public void atualizarProduto(long id, String nome, String categoria, int qtdeEstoque, 
                                double preco, double precoDesconto) throws ProdutoNaoEncontradoException{

        colecaoProduto.atualizar(id, nome, categoria, qtdeEstoque, preco, precoDesconto);
    }



    //VENDAS
    public List<Venda> listarVendas(){
        return colecaoVenda.listarTodos();
    }

    public Venda listarVendaPorId(long id) throws VendaNaoEncontradaException{
        return colecaoVenda.listarPorId(id);
    }



    //AQUISIÇÕES
    public void adicionarAquisicao(String cnpjFornecedor, long idProduto, int qtdeProduto,
                                    double custo, String dataAquisicao) throws ProdutoNaoEncontradoException {
        //Buscando produto pelo ID
        Produto produto = listarProdutoPorId(idProduto);
        
        //Configurando a data
        Calendar c = Calendar.getInstance();
        String [] dataArray = dataAquisicao.split("-", 0);
        c.set(Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]));
        Date data = c.getTime();

        //Criando a aquisição e adicionando ao repositorio
        Aquisicao aquisicao = new Aquisicao(data, cnpjFornecedor, produto, qtdeProduto, custo);
        colecaoAquisicao.adicionar(aquisicao);
        
        //Atualizando o produto em questão no estoque
        atualizarProduto(produto.getId(), produto.getNome(), produto.getCategoria(), 
        (produto.getQtdeEstoque() + qtdeProduto), produto.getPreco(), produto.getPrecoDesconto());
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
