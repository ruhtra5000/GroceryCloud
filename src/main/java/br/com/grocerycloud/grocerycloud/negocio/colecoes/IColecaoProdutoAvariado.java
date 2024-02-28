package br.com.grocerycloud.grocerycloud.negocio.colecoes;

import java.util.Date;
import java.util.List;

import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.AvariadoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoSemEstoqueException;

/**
 * Interface que representa o contrado dum produto avariado, definindo quais
 * métodos serão necessários.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Interface de negócio
 */

public interface IColecaoProdutoAvariado {

        ProdutoAvariado listarPorId(long id) throws AvariadoNaoEncontradoException;

        ProdutoAvariado listarPorIdProduto(long id)
                        throws ProdutoNaoEncontradoException, AvariadoNaoEncontradoException;

        List<ProdutoAvariado> listarTodos();

        void avariar(long id, int qtdeAvariados, Date dataChecagem)
                        throws ProdutoNaoEncontradoException, ProdutoSemEstoqueException;

}
