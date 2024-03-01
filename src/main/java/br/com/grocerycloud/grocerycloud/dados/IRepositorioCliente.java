package br.com.grocerycloud.grocerycloud.dados;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;

/**
 * Interface que representa o repositório de cliente e seus métodos.
 * @author João Victor Leite Dos Santos
 * @category Repositório de dados
 */

@Repository
public interface IRepositorioCliente extends JpaRepository <Cliente, Long> {
    public
    Cliente findById(long id);
    public List<Cliente> findAllByNome(String nome);
    public Cliente findByCpf(String cpf);
    public Cliente findByCpfAndSenha(String cpf, String senha);
}