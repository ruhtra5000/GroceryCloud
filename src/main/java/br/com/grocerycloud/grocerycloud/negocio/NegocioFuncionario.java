package br.com.grocerycloud.grocerycloud.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioFuncionario;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoFuncionario;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Funcionario;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.FuncionarioNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.NomeNaoEncontradoException;

/**
 * Esta classe implementa as ações e as regras de negocio relacionadas a um
 * funcionario.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de negocio da aplicação
 */

@Service
public class NegocioFuncionario implements IColecaoFuncionario {
    @Autowired
    private IRepositorioFuncionario repositorioFuncionario;

    @Override
    public void adicionar(Funcionario funcionario) {
        repositorioFuncionario.save(funcionario);
    }

    @Override
    public void remover(long id) throws FuncionarioNaoEncontradoException {
        Funcionario removed = listarPorId(id);
        repositorioFuncionario.delete(removed);
    }

    @Override
    public void atualizar(long id, String nome, String cpf, String telefone, String email, String senha, int tipoAcesso) throws FuncionarioNaoEncontradoException {
        Funcionario funcionario = listarPorId(id);
		
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionario.setTelefone(telefone);
		funcionario.setEmail(email);
        funcionario.setSenha(senha);
        funcionario.setTipoAcesso(tipoAcesso);

		repositorioFuncionario.save(funcionario);
	}

    @Override
    public Funcionario listarPorId(long id) throws FuncionarioNaoEncontradoException {
        Funcionario funcionario = repositorioFuncionario.findById(id);
		if (funcionario == null)
			throw new FuncionarioNaoEncontradoException();	
		return funcionario;
    }

    @Override
    public List<Funcionario> listarTodos() {
        return repositorioFuncionario.findAll();
    }

    @Override
    public Funcionario listarPorCpf(String cpf) throws CpfNaoEncontradoException {
        Funcionario funcionario = repositorioFuncionario.findByCpf(cpf);
		if (funcionario == null)
			throw new CpfNaoEncontradoException();
		return funcionario;  
    }

    @Override
    public Funcionario buscarPorCpfESenha(String cpf, String senha) {
        return repositorioFuncionario.findByCpfAndSenha(cpf, senha);
    }

    @Override
    public List<Funcionario> listarPorNome(String nome) throws NomeNaoEncontradoException {
        List<Funcionario> funcionario = repositorioFuncionario.findAllByNome(nome);
		if (funcionario.isEmpty())
			throw new NomeNaoEncontradoException();
		return funcionario;  
    }
}


