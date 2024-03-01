package br.com.grocerycloud.grocerycloud.negocio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioProduto;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.AvariadoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.QuantidadeProdutoInsuficienteException;

/**
 * Classe que implementa os métodos requisitados no contrato dum produto
 * avariado.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de negocio da aplicação
 */

@Service
public class NegocioProdutoAvariado implements IColecaoProdutoAvariado {
    @Autowired
    private IRepositorioProdutoAvariado repositorioProdutoAvariado;
    @Autowired
    private IRepositorioProduto repositorioProduto;

    // Repositório
    @Override
    public List<ProdutoAvariado> listarTodos() {

        List<ProdutoAvariado> produtos = repositorioProdutoAvariado.findAllByOrderById();

        return produtos;
    }

    @Override
    public ProdutoAvariado listarPorId(long id) throws AvariadoNaoEncontradoException {

        ProdutoAvariado produto = repositorioProdutoAvariado.findById(id);

        if (produto == null)
            throw new AvariadoNaoEncontradoException();

        return produto;
    }

    @Override
    public ProdutoAvariado listarPorIdProduto(long id)
            throws ProdutoNaoEncontradoException, AvariadoNaoEncontradoException {
        Produto produto = repositorioProduto.findById(id);
        if (produto == null)
            throw new ProdutoNaoEncontradoException();

        ProdutoAvariado avariado = repositorioProdutoAvariado.findByProduto(produto);
        if (avariado == null)
            throw new AvariadoNaoEncontradoException();

        return avariado;
    }

    @Override
    public List<ProdutoAvariado> listarTodosPorIdProduto(long id)
            throws ProdutoNaoEncontradoException, AvariadoNaoEncontradoException {
        Produto produto = repositorioProduto.findById(id);
        if (produto == null)
            throw new ProdutoNaoEncontradoException();

            List<ProdutoAvariado> avariados = repositorioProdutoAvariado.findAllByProduto(produto);
        if (avariados.isEmpty())
            throw new AvariadoNaoEncontradoException();

        return avariados;
    }



    @Override
    public void avariar(long idProduto, int qtdeAvariados, Date dataChecagem)
            throws ProdutoNaoEncontradoException, QuantidadeProdutoInsuficienteException {

        Produto produto = repositorioProduto.findById(idProduto);
        if (produto == null)
            throw new ProdutoNaoEncontradoException();

        if (produto.getQtdeEstoque() < qtdeAvariados)
            throw new QuantidadeProdutoInsuficienteException();

        Date date = new Date();
        ProdutoAvariado avariado = new ProdutoAvariado(produto, qtdeAvariados, date);

        produto.setQtdeEstoque(produto.getQtdeEstoque() - qtdeAvariados);

        repositorioProduto.save(produto);
        repositorioProdutoAvariado.save(avariado);
    }

}
