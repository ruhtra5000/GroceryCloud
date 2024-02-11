package br.com.grocerycloud.grocerycloud.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;

/** 
 * Esta interface representa o repositório de aquisições, 
 * com os métodos necessários para realizar seu armazenamento.
 * @author Arthur de Sá Tenório
 * @category Repositório de dados
*/

@Repository
public interface InterfaceRepositorioAquisicoes extends JpaRepository<Aquisicao, Long>{
    //Criação e deleção
    Aquisicao save(Aquisicao venda);
    void deleteById(long id);
    //Buscas
    List<Aquisicao> findAll();
    List<Aquisicao> findById(long id);
    List<Aquisicao> findByCnpjFornecedor(String cnpjFornecedor);
}