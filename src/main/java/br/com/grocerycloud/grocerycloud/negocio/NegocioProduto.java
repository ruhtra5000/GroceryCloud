package br.com.grocerycloud.grocerycloud.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioProduto;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProduto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.CategoriaNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.NomeNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoJaRegistradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;

/**
 * Classe que implementa os métodos requisitados no contrato dum produto.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de negocio da aplicação
 */

@Service
public class NegocioProduto implements IColecaoProduto {
	@Autowired
	private IRepositorioProduto repositorioProduto;

	// Repositório
	@Override
	public void adicionar(Produto produto) throws ProdutoJaRegistradoException {

		Produto busca = repositorioProduto.findByNome(produto.getNome());

		if (busca != null)
			if (busca.getNome().equals(produto.getNome()))
				throw new ProdutoJaRegistradoException();

		repositorioProduto.save(produto);
	}

	@Override
	public void atualizar(long id, String nome, String categoria, int qtdeEstoque, double preco, double precoDesconto)
			throws ProdutoNaoEncontradoException {
		Produto produto = listarPorId(id);

		produto.setCategoria(categoria);
		produto.setQtdeEstoque(qtdeEstoque);
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setPrecoDesconto(precoDesconto);

		repositorioProduto.save(produto);
	}

	@Override
	public Produto listarPorId(long id) throws ProdutoNaoEncontradoException {

		Produto produto = repositorioProduto.findById(id);

		if (produto == null)
			throw new ProdutoNaoEncontradoException();

		return produto;
	}

	@Override
	public List<Produto> listarTodos() {
		return repositorioProduto.findAllByOrderById();
	}

	@Override
	public Produto listarPorNome(String nome) throws NomeNaoEncontradoException {
		Produto produto = repositorioProduto.findByNome(nome);

		if (produto == null)
			throw new NomeNaoEncontradoException();

		return produto;
	}

	@Override
	public List<Produto> listarPorCategoria(String categoria) throws CategoriaNaoEncontradaException {

		List<Produto> produtos = repositorioProduto.findAllByCategoria(categoria);

		if (produtos.isEmpty())
			throw new CategoriaNaoEncontradaException();

		return produtos;
	}

	@Override
	public List<Produto> listarPorDesconto() {
		return repositorioProduto.findAllByPrecoDescontoNot(-1);
	}

	// Funções produtos
	@Override
	public void aplicarDesconto(long id, double novoPreco) throws ProdutoNaoEncontradoException {
		Produto produtoComDesconto = listarPorId(id);
		produtoComDesconto.setPrecoDesconto(novoPreco);
	}

	@Override
	public boolean temDesconto(Produto p) {
		return p.getPrecoDesconto() != -1;
	}

	

}
