package br.com.grocerycloud.grocerycloud.negocio.colecoes;
import java.util.List;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Funcionario;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.FuncionarioDuplicadoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.NomeNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.FuncionarioNaoEncontradoException;

/** 
 * Esta classe implementa o contrato de um funcionario, estabelecendo 
 * os métodos que devem ser executados pela classe de negocio de funcionario
 * @author Victor Cauã Tavares Inácio
 * @category Interface de negócio
*/

public interface IColecaoFuncionario {
    void adicionar(Funcionario funcionario) throws FuncionarioDuplicadoException;
    void atualizar(long id, String nome, String telefone, String email, String senha, int tipoAcesso) throws FuncionarioNaoEncontradoException;

    Funcionario listarPorId(long id) throws FuncionarioNaoEncontradoException;
    Funcionario listarPorCpf(String cpf) throws CpfNaoEncontradoException;
    List<Funcionario> listarTodos();
    List<Funcionario> listarPorNome(String nome) throws NomeFuncionarioNaoEncontradoException;
    Funcionario buscarPorCpfESenha(String cpf, String senha);
} 