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

		List<Produto> busca = repositorioProduto.findAllByNome(produto.getNome());

		if (!busca.isEmpty()) {
			for (Produto p : busca) {
				if (p.getNome().equals(produto.getNome()))
					throw new ProdutoJaRegistradoException();
			}
		}

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

		List<Produto> produtos = repositorioProduto.findAll();

		return produtos;
	}

	@Override
	public List<Produto> listarPorNome(String nome) throws NomeNaoEncontradoException {
		List<Produto> produtos = repositorioProduto.findAllByNome(nome);

		if (produtos.isEmpty())
			throw new NomeNaoEncontradoException();

		return produtos;
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

	// Produto avariado

}
