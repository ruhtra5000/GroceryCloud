package br.com.grocerycloud.grocerycloud.dados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;

/**
 * Interface que representa o repositório de produtos e seus métodos.
 * @author Guilherme Paes Cavalcanti
 * @category Repositório de dados
 */

@Repository
public interface IRepositorioProduto extends JpaRepository <Produto, Long> {
	
	public Produto findById(long id);
	public List<Produto> findAllByNome(String nome);
	public List<Produto> findAllByCategoria(String categoria);
	public List<Produto> findAllByPrecoDescontoNot(double precoDesconto);
	
}
