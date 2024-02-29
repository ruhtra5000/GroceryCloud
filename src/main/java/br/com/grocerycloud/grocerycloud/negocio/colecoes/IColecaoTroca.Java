package br.com.grocerycloud.grocerycloud.negocio.colecoes;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Troca;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.troca.TrocaNaoEncontrada;

import java.util.Date;
import java.util.List;

/**
 * Interface que representa a troca de produtos avariados.
 *
 * @author João Victor Santos
 * @category Interface de negócio
 */
public interface IColecaoTroca {

    public void adicionarTroca(ProdutoAvariado produtoAvariado, Date date) ;
    public Troca buscar(long id) throws TrocaNaoEncontrada;
    List<Troca> listaTodas();
}