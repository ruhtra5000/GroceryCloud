package br.com.grocerycloud.grocerycloud.dados;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;

/**
 * Interface que representa o repositório de produtos avariados e seus métodos.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Repositório de dados
 */

@Repository
public interface IRepositorioProdutoAvariado extends JpaRepository<ProdutoAvariado, Long> {

	public ProdutoAvariado findById(long id);

	public List<ProdutoAvariado> findAllByOrderById();

	public ProdutoAvariado findByProduto(Produto produto);

	public List<ProdutoAvariado> findAllByProduto(Produto produto);

	/**
	 * @return Lista com apenas um objeto, o qual contém o nome do produto com mais
	 *         avarias no sistema e sua quantidade total.
	 */
	@Query("SELECT new map(p.produto.nome as nome, SUM(p.qtdeAvariados) as totalAvariados) " +
			"FROM ProdutoAvariado p " +
			"GROUP BY p.produto.nome " +
			"ORDER BY totalAvariados DESC LIMIT 1")
	public List<Map<String, Object>> findMaiorOcorrenciaProdutoAvariado();

}
