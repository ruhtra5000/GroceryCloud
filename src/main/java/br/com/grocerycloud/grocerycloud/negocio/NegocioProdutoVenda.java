package br.com.grocerycloud.grocerycloud.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.ProdutoVendaNaoEncotradoException;

/**
 * Esta classe implementa as ações e as regras de negocio relacionadas a um
 * produtoVenda.
 * 
 * @author Arthur de Sá Tenório
 * @category Classe de negocio da aplicação
 */

@Service
public class NegocioProdutoVenda implements IColecaoProdutoVenda {
    @Autowired
    private IRepositorioProdutoVenda repositorioProdutoVenda;

    @Override
    public void adicionar(ProdutoVenda produtoVenda) {
        repositorioProdutoVenda.save(produtoVenda);
    }

    @Override
    public ProdutoVenda listarPorId(long id) throws ProdutoVendaNaoEncotradoException {
        ProdutoVenda produtoVenda = repositorioProdutoVenda.findById(id);
        if (produtoVenda == null)
            throw new ProdutoVendaNaoEncotradoException();
        else
            return produtoVenda;
    }
}
