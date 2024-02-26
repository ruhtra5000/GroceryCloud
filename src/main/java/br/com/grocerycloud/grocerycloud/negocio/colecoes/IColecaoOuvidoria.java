package br.com.grocerycloud.grocerycloud.negocio.colecoes;
import java.util.List;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Ouvidoria;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.ouvidoria.ClienteNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.ouvidoria.OuvidoriaNaoEncontradaException;

/** 
 * Esta classe implementa o contrato de uma ouvidoria, estabelecendo 
 * os métodos que devem ser executados pela classe de negocio de ouvidoria
 * @author Victor Cauã Tavares Inácio
 * @category Interface de negócio
*/

public interface IColecaoOuvidoria {
    void adicionar(Ouvidoria ouvidoria);

    List<Ouvidoria> listarTodos();
    Ouvidoria listarPorId(long id) throws OuvidoriaNaoEncontradaException;
    List<Ouvidoria> listarPorCliente(Cliente cliente) throws ClienteNaoEncontradoException;
} 
    
