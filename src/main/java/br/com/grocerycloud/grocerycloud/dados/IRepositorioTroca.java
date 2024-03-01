package br.com.grocerycloud.grocerycloud.dados;

import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Troca;

/**
 * Interface que representa o repositório de troca e seus métodos.
 *
 * @author João Victor Leite Dos Santos
 * @category Repositório de dados
 */

@Repository
public interface IRepositorioTroca extends JpaRepository<Troca, Long> {
    public List<Troca> findAllByOrderById();
    public Troca findById(long id);
    public Troca findByProdutoAvariado(ProdutoAvariado produtoAvariado);
}
