package br.com.grocerycloud.grocerycloud.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioOuvidoria;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoOuvidoria;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Ouvidoria;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.ouvidoria.ClienteNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.ouvidoria.OuvidoriaNaoEncontradaException;

/**
 * Esta classe implementa as ações e as regras de negocio relacionadas a uma
 * Ouvidoria.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de negocio da aplicação
 */

@Service
public class NegocioOuvidoria implements IColecaoOuvidoria {
    @Autowired
    private IRepositorioOuvidoria repositorioOuvidoria;

    @Override
    public void adicionar(Ouvidoria ouvidoria) {
        repositorioOuvidoria.save(ouvidoria);
    }

    @Override
    public Ouvidoria listarPorId(long id) throws OuvidoriaNaoEncontradaException {
        Ouvidoria ouvidoria = repositorioOuvidoria.findById(id);
		if (ouvidoria == null)
			throw new OuvidoriaNaoEncontradaException();	
		return ouvidoria;
    }

    @Override
    public List<Ouvidoria> listarPorCliente(Cliente cliente) throws ClienteNaoEncontradoException {
        List<Ouvidoria> ouvidoria = repositorioOuvidoria.findAllByCliente(cliente);
		if (ouvidoria.isEmpty())
			throw new ClienteNaoEncontradoException();
		return ouvidoria;  
    }

    @Override
    public List<Ouvidoria> listarTodos() {
        return repositorioOuvidoria.findAllByOrderById();
    }

}


