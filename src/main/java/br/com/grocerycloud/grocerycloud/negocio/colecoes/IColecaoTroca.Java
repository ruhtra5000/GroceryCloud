package br.com.grocerycloud.grocerycloud.negocio.colecoes;

import java.util.Date;
import java.util.List;

import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Troca;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.troca.TrocaNaoEncontrada;

public interface IColecaoTroca {
    public void adicionarTroca(ProdutoAvariado produtoAvariado, Date date) ;
    public Troca buscarPorId(long id) throws TrocaNaoEncontrada;
    List<Troca> listarTodas();
}
