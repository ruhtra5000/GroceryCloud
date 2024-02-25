package br.com.grocerycloud.grocerycloud.negocio.colecoes;

import java.util.List;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.AquisicaoNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjNaoEncontradoException;

/** 
 * Esta classe implementa o contrato de uma aquisição, estabelecendo 
 * os métodos que devem ser executados pela classe de negocio de aquisição
 * @author Arthur de Sá Tenório
 * @category Interface de negócio
*/

public interface IColecaoAquisicao {
    void adicionar(Aquisicao aquisicao);
    List<Aquisicao> listarTodos();
    Aquisicao listarPorId(long id) throws AquisicaoNaoEncontradaException;
    List<Aquisicao> listarPorCNPJ(String cnpj) throws CnpjNaoEncontradoException;
} 