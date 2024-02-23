package br.com.grocerycloud.grocerycloud.negocio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioProduto;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProduto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.CategoriaNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.EstoqueVazioException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.NomeNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoSemEstoqueException;

/** 
 * Classe que implementa os métodos requisitados no contrato dum produto.
 * @author Guilherme Paes Cavalcanti
 * @category Classe de negocio da aplicação
*/

@Service
public class NegocioProduto implements IColecaoProduto{
    @Autowired
    private IRepositorioProduto repositorioProduto;

    // Repositório
	@Override
	public void adicionar(Produto produto) {
		repositorioProduto.save(produto);
	}

	@Override
	public void remover(long id) throws ProdutoNaoEncontradoException{
		Produto removed = listarPorId(id);
		repositorioProduto.delete(removed);
	}

	@Override
	public void atualizar(long id, String nome, String categoria, int qtdeEstoque, double preco, double precoDesconto) throws ProdutoNaoEncontradoException {
		Produto produto = listarPorId(id);
		
		produto.setCategoria(categoria);
		produto.setQtdeEstoque(qtdeEstoque);
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setPrecoDesconto(precoDesconto);
		
	}

	@Override
	public Produto listarPorId(long id) throws ProdutoNaoEncontradoException {
		
		Produto produto = repositorioProduto.findById(id);
		
		if (produto == null)
			throw new ProdutoNaoEncontradoException();
				
		return produto;
	}

	@Override
	public List<Produto> listarTodos() throws EstoqueVazioException {
		
		List<Produto> produtos = repositorioProduto.findAll();
		
		if (produtos.isEmpty())
			throw new EstoqueVazioException();
		
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
	public List<Produto> listarPorCategoria(String categoria) throws CategoriaNaoEncontradaException{
		
		List<Produto> produtos = repositorioProduto.findAllByCategoria(categoria);
		
		if (produtos.isEmpty())
			throw new CategoriaNaoEncontradaException();
		
		return produtos;
	}

	
	// Funções produtos
	@Override
	public void aplicarDesconto(long id, double novoPreco) throws ProdutoNaoEncontradoException {
		Produto produtoComDesconto = listarPorId(id);
		produtoComDesconto.setPrecoDesconto(novoPreco);
	}
	
	// Produto avariado //MODIFICAR
	@Override
	public void avariar(long id, int qtdeAvariados) throws ProdutoNaoEncontradoException, ProdutoSemEstoqueException{
		Produto produto = listarPorId(id);
		
		if(produto.getQtdeEstoque() < qtdeAvariados)
			throw new ProdutoSemEstoqueException();
		
		Date date = new Date();
		
		ProdutoAvariado avariado = new ProdutoAvariado(produto, qtdeAvariados, date);
		//repositorioProduto.save(avariado);
		produto.setQtdeEstoque(produto.getQtdeEstoque() - qtdeAvariados);
		
	}
	
	
}
