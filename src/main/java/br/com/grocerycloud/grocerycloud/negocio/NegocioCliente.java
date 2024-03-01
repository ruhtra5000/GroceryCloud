package br.com.grocerycloud.grocerycloud.negocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioCliente;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoCliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.cliente.*;

/**
 * Esta classe implementa as ações e as regras de negocio relacionadas a um Cliente.
 * @author João Victor Leite Dos Santos
 * @category Classe de negocio da aplicação
 */

@Service
public class NegocioCliente implements IColecaoCliente{
    @Autowired
    private IRepositorioCliente repositorioCliente;

    @Override
    public void adicionar(Cliente cliente) {
        repositorioCliente.save(cliente);
    }

    @Override
    public void remover(long id) throws ClienteNaoEncontradoException {
            Cliente cliente = listarPorId(id);
            repositorioCliente.delete(cliente);

    }

    @Override
    public void atualizar(long id, String nome, String cpf, String senha) throws ClienteNaoEncontradoException {
        Cliente cliente = listarPorId(id);

        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setSenha(senha);

        repositorioCliente.save(cliente);
    }

    @Override
    public Cliente listarPorId(long id) throws ClienteNaoEncontradoException {
        Cliente cliente = repositorioCliente.findById(id);
        if (cliente == null)
            throw new ClienteNaoEncontradoException();
        return cliente;
    }

    @Override
    public Cliente listarPorCpf(String cpf) throws CpfNaoEncontradoException {
        Cliente cliente = repositorioCliente.findByCpf(cpf);
        if (cliente == null)
            throw new CpfNaoEncontradoException();
        return cliente;
    }

    @Override
    public List<Cliente> listarTodos() {
        return repositorioCliente.findAll();
    }

    @Override
    public List<Cliente> listarPorNome(String nome) throws NomeClienteNaoEncontradoException {
        List<Cliente> clientes = repositorioCliente.findAllByNome(nome);
        if (clientes.isEmpty())
            throw new NomeClienteNaoEncontradoException();
        return clientes;
    }
    @Override
    public Cliente buscarPorCpfESenha(String cpf, String senha) {
        return repositorioCliente.findByCpfAndSenha(cpf, senha);
    }
}