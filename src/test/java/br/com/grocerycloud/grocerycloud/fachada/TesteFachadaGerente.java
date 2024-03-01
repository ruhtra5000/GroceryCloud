package br.com.grocerycloud.grocerycloud.fachada;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioAquisicao;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioProduto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.AquisicaoNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjInvalidoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.NomeNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoJaRegistradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Esta classe busca testar a fachada do gerente
 * 
 * @author Arthur de Sá Tenório
 * @category Classe de teste
 */

@SpringBootTest
public class TesteFachadaGerente {
    @Autowired
    private IRepositorioAquisicao repositorioAquisicao;
    @Autowired
    private IRepositorioProduto repositorioProduto;
    @Autowired
    private FachadaGerente fachadaGerente;

    /**
     * Método de teste de integração de aquisição
     * 
     * @author Arthur de Sá Tenório
     */
    @Test
    public void cadastroAquisicaoTest() {
        long l = 1;

        long qtdeAquisicoes = repositorioAquisicao.count();
        try {
            fachadaGerente.adicionarAquisicao("91.827.947/0001-26", l, 3, 25.0, "2024-03-21");
        } catch (ProdutoNaoEncontradoException err) {
            System.out.println(err.getMessage());
        } catch (CnpjInvalidoException err2) {
            System.out.println(err2.getMessage());
        }

        long qtdeAquisicoes2 = repositorioAquisicao.count();
        assertEquals(qtdeAquisicoes2, qtdeAquisicoes + 1);
    }

    /**
     * Método de teste de integração de aquisição
     * 
     * @author Arthur de Sá Tenório
     */
    @Test
    public void buscarAquisicaoPorIdTest() {
        long l = 1;
        long esperado = 2;
        try {
            Aquisicao a = fachadaGerente.buscarAquisicaoPorId(l);
            assertEquals("65.588.276/0001-88", a.getCnpjFornecedor());
            assertEquals(esperado, a.getProduto().getId());
            assertEquals(100, a.getCusto());
            assertEquals(5, a.getQtdeProduto());
        } catch (AquisicaoNaoEncontradaException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Método de teste de integração de aquisição
     * 
     * @author Arthur de Sá Tenório
     */
    @Test
    public void buscarAquisicaoPorCNPJTest() {
        long esperado = 3;
        try {
            List<Aquisicao> a = fachadaGerente.buscarAquisicaoPorCnpj("62.323.096/0001-86");
            assertEquals(esperado, a.get(0).getId());
            assertEquals(esperado, a.get(0).getProduto().getId());
            assertEquals(25, a.get(0).getCusto());
            assertEquals(10, a.get(0).getQtdeProduto());
        } catch (CnpjNaoEncontradoException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Método de teste de integração de Produtos
     * 
     * @author Guilherme Paes Cavalcanti
     */
    @Test
    public void cadastroProdutoTest() {

        try {

            long countProdutosBefore = repositorioProduto.count();
            fachadaGerente.adicionarProduto("Nome", "Categoria", 1, 1.0);
            long countProdutosAfter = repositorioProduto.count();

            assertEquals(countProdutosAfter, countProdutosBefore + 1);

        } catch (ProdutoJaRegistradoException err) {
            System.err.println(err.getMessage());
        }

    }

    /**
     * Método de teste de integração de Produtos
     * 
     * @author Guilherme Paes Cavalcanti
     */
    @Test
    public void buscarProdutoPorNomeTest() {

        try {
            String busca = "Maçã";
            Produto produto = fachadaGerente.listarProdutoPorNome(busca);

            assertEquals(27, produto.getId());
            assertEquals("Fruta", produto.getCategoria());
            assertEquals(151, produto.getQtdeEstoque());
            assertEquals(5, produto.getPreco());
            assertEquals(-1, produto.getPrecoDesconto());

        } catch (NomeNaoEncontradoException err) {
            System.err.println(err.getMessage());
        }

    }

    /**
     * Método de teste de integração de Produtos
     * 
     * @author Guilherme Paes Cavalcanti
     */
    @Test
    public void atualizarProdutoTest() {

        
        try {
            long idProduto = 1;
            
            fachadaGerente.atualizarProduto(idProduto, "Nome atualizado", "Categoria atualizada", 176, 176.0, -1.0);

            Produto p = fachadaGerente.listarProdutoPorId(idProduto);

            assertEquals(idProduto, p.getId());
            assertEquals("Nome atualizado", p.getNome());
            assertEquals("Categoria atualizada", p.getCategoria());
            assertEquals(176, p.getQtdeEstoque());
            assertEquals(176.0, p.getId());
            assertEquals(-1, p.getId());

        } catch (Exception err) {

        }

    }
}
