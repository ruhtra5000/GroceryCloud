package br.com.grocerycloud.grocerycloud.dados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Funcionario;

/**
 * Interface que representa o repositório de funcionario e seus métodos.
 * @author Victor Cauã Tavares Inácio
 * @category Repositório de dados
 */

@Repository
public interface IRepositorioFuncionario extends JpaRepository <Funcionario, Long> {
	public List<Funcionario> findAllByOrderById();
	public Funcionario findById(long id);
	public List<Funcionario> findAllByNome(String nome);
	public Funcionario findByCpf(String cpf);
	public Funcionario findByCpfAndSenha(String cpf, String senha);
}