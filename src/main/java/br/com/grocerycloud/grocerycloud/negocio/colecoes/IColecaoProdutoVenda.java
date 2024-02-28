package br.com.grocerycloud.grocerycloud.negocio.colecoes;

import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.ProdutoVendaNaoEncotradoException;

/** 
 * Esta classe implementa o contrato de um produtoVenda, estabelecendo 
 * os métodos que devem ser executados pela classe de negocio de venda
 * @author Arthur de Sá Tenório
 * @category Interface de negócio
*/

public interface IColecaoProdutoVenda {
    void adicionar(ProdutoVenda produtoVenda);
    ProdutoVenda listarPorId(long id) throws ProdutoVendaNaoEncotradoException;
} 
