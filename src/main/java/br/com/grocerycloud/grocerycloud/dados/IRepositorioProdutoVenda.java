package br.com.grocerycloud.grocerycloud.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoVenda;

/** 
 * Esta interface representa o repositório de produtosVenda, 
 * com os métodos necessários para realizar seu armazenamento.
 * @author Arthur de Sá Tenório
 * @category Repositório de dados
*/

@Repository
public interface IRepositorioProdutoVenda extends JpaRepository<ProdutoVenda, Long>{
    public ProdutoVenda findById(long id);
}
