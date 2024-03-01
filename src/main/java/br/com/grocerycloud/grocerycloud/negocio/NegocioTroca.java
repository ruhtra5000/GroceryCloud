package br.com.grocerycloud.grocerycloud.negocio;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoTroca;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Troca;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioTroca;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.troca.TrocaNaoEncontrada;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta classe implementa as ações e as regras de negocio relacionadas a uma troca.
 * @author João Victor Leite Dos Santos
 * @category Classe de negocio da aplicação
 */
@Service
public class NegocioTroca implements IColecaoTroca {
    @Autowired
    private IRepositorioTroca repositorioTroca;

    @Override
    public void adicionarTroca(ProdutoAvariado produtoAvariado, Date date) {
        Troca troca = new Troca(produtoAvariado, date);
        repositorioTroca.save(troca);
    }

    @Override
    public Troca buscarPorId(long id) throws TrocaNaoEncontrada {
        Troca troca = repositorioTroca.findById(id);
        if (troca == null) {
            throw new TrocaNaoEncontrada();
        }
        return troca;
    }

    @Override
    public List<Troca> listarTodas() {
        return repositorioTroca.findAllByOrderById();
    }
}