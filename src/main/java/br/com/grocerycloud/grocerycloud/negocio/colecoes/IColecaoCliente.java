package br.com.grocerycloud.grocerycloud.negocio.colecoes;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.cliente.*;
import java.util.List;

/**
 * Esta classe implementa o registro de um cliente, estabelecendo
 * os métodos que devem ser executados pela classe de negocio de cliente
 * @author João Victor Leite Dis Santos
 * @category Interface de negócio
 */

public interface IColecaoCliente {
    void adicionar(Cliente cliente);
    void remover(long id) throws ClienteNaoEncontradoException;
    void atualizar(long id, String nome, String cpf, String senha) throws ClienteNaoEncontradoException;

    Cliente listarPorId(long id) throws ClienteNaoEncontradoException;
    Cliente listarPorCpf(String cpf) throws CpfNaoEncontradoException;
    List<Cliente> listarTodos();
    List<Cliente> listarPorNome(String nome) throws NomeClienteNaoEncontradoException;
    Cliente buscarPorCpfESenha(String cpf, String senha);
}