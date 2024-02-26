package br.com.grocerycloud.grocerycloud.dados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Ouvidoria;

/**
 * Interface que representa o repositório de ouvidoria e seus métodos.
 * @author Victor Cauã Tavares Inácio
 * @category Repositório de dados
 */

@Repository
public interface IRepositorioOuvidoria extends JpaRepository <Ouvidoria, Long> {
	public Ouvidoria findById(long id);
	public List<Ouvidoria> findAllByCliente(Cliente cliente);
}