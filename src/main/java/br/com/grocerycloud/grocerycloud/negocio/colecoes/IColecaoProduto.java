package br.com.grocerycloud.grocerycloud.negocio.colecoes;

import java.util.List;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.CategoriaNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.NomeNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoJaRegistradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;

/**
 * Interface que representa o contrado dum produto, definindo quais métodos
 * serão necessários.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Interface de negócio
 */

public interface IColecaoProduto {

        // Repositório
        void adicionar(Produto produto) throws ProdutoJaRegistradoException;

        void atualizar(long id, String nome, String categoria, int qtdeEstoque, double preco, double precoDesconto)
                        throws ProdutoNaoEncontradoException;

        Produto listarPorId(long id) throws ProdutoNaoEncontradoException;

        List<Produto> listarTodos();

        List<Produto> listarPorNome(String nome) throws NomeNaoEncontradoException;

        List<Produto> listarPorCategoria(String categoria) throws CategoriaNaoEncontradaException;

        // Funções produto
        void aplicarDesconto(long id, double novoPreco) throws ProdutoNaoEncontradoException;

}
