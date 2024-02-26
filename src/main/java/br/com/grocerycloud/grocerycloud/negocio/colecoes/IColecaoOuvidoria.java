package br.com.grocerycloud.grocerycloud.negocio.colecoes;
import java.util.List;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Ouvidoria;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.ouvidoria.ClienteNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.ouvidoria.OuvidoriaNaoEncontradaException;

/** 
 * Esta classe implementa o contrato de uma Ouvidoria, estabelecendo 
 * os métodos que devem ser executados pela classe de negocio de Ouvidoria
 * @author Victor Cauã Tavares Inácio
 * @category Interface de negócio
*/

public interface IColecaoOuvidoria {

    void adicionar(Ouvidoria ouvidoria);

    Ouvidoria listarPorId(long id) throws OuvidoriaNaoEncontradaException;
    List<Ouvidoria> listarTodos();
    List<Ouvidoria> listarPorCliente(Cliente cliente) throws ClienteNaoEncontradoException;

} 
    
