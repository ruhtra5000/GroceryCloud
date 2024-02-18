package br.com.grocerycloud.grocerycloud.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.AquisicaoNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.CnpjNaoEncontradoException;

import java.util.List;

/** 
 * Esta classe implementa as ações e as regras de negocio relacionadas a uma aquisição.
 * @author Arthur de Sá Tenório
 * @category Classe de negocio da aplicação
*/

@Service
public class NegocioAquisicao implements IColecaoAquisicao {
    @Autowired
    private IRepositorioAquisicao repositorioAquisicao;

    @Override
    public void adicionar(Aquisicao aquisicao) { //Atualizar o estoque
        repositorioAquisicao.save(aquisicao);
    }

    @Override
    public List<Aquisicao> listarTodos() {
        return repositorioAquisicao.findAll();
    }

    @Override
    public Aquisicao listarPorId(long id) throws AquisicaoNaoEncontradaException {
        Aquisicao aquisicao = repositorioAquisicao.findById(id);
        if(aquisicao == null)
            throw new AquisicaoNaoEncontradaException();
        return aquisicao;
    }

    @Override
    public List<Aquisicao> listarPorCNPJ(String cnpj) throws CnpjNaoEncontradoException {
        List<Aquisicao> aquisicoes = repositorioAquisicao.findByCnpjFornecedor(cnpj);
        if(aquisicoes.isEmpty())
            throw new CnpjNaoEncontradoException();
        return aquisicoes;
    }
}
