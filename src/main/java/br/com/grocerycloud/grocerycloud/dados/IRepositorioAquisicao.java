package br.com.grocerycloud.grocerycloud.dados;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;

/**
 * Esta interface representa o repositório de aquisições,
 * com os métodos necessários para realizar seu armazenamento.
 * 
 * @author Arthur de Sá Tenório
 * @category Repositório de dados
 */

@Repository
public interface IRepositorioAquisicao extends JpaRepository<Aquisicao, Long> {
    public List<Aquisicao> findAllByOrderById();

    public Aquisicao findById(long id);

    public List<Aquisicao> findAllByCnpjFornecedor(String cnpjFornecedor);

    /**
     * Método que obtém o custo total das aquisições.
     * 
     * @author Guilherme Paes Cavalcanti
     */
    @Query("SELECT COALESCE(SUM(a.custo), 0) FROM Aquisicao as a")
    public double getCustosTotais();

    /**
     * @author Guilherme Paes Cavalcanti
     * @return Lista contendo uma instância de nome e qtde dum produto presente numa
     *         aquisição
     */
    @Query("SELECT a.cnpjFornecedor as Cnpj, " +
            "SUM(a.custo) as Total " +
            "FROM Aquisicao as a " +
            "GROUP BY Cnpj " +
            "ORDER BY Total DESC")
    public List<Map<String, Object>> findAllAquisicoesSumCustoGroupByCnpj();

    /**
     * @author Guilherme Paes Cavalcanti
     * @return Lista contendo apenas um objeto, o qual contém o nome e a quantidade
     *         do produto mais adquirido no sistema.
     */
    @Query("SELECT a.produto.nome as Nome, SUM(a.qtdeProduto) as Total " +
            "FROM Aquisicao as a " +
            "GROUP BY Nome " +
            "ORDER BY Total DESC LIMIT 1")
    public List<Map<String, Object>> findAllProdutosQuantityGroupByNomeLimit1();

}