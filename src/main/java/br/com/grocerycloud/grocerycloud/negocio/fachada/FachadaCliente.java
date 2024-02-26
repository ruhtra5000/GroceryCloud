package br.com.grocerycloud.grocerycloud.negocio.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoOuvidoria;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Ouvidoria;

/** 
 * Esta classe representa a fachada que será utilizada pelos clientes.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de fachada da aplicação
*/

@Service
public class FachadaCliente {
    @Autowired
    private IColecaoOuvidoria colecaoOuvidoria;

     /** 
     * Métodos que tangem a Ouvidoria, na fachada do cliente.
     * @author Victor Cauã Tavares InácioS
    */
    //OUVIDORIA
    public void adicionarOuvidoria(long Idcliente, String mensagem){ //INCOMPLETO

    }
    
}
