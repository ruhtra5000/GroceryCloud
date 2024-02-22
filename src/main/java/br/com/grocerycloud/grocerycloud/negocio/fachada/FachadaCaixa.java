package br.com.grocerycloud.grocerycloud.negocio.fachada;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Funcionario;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Usuario;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Venda;

/** 
 * Esta classe representa a fachada que será utilizada pelos operadores de caixa.
 * @author Arthur de Sá Tenório
 * @category Classe de fachada da aplicação
*/

@Service
public class FachadaCaixa {
    @Autowired
    private IColecaoVenda colecaoVenda;
    //NECESSÁRIO COLEÇAO DE PRODUTOS, USUARIOS

    //Armazena temporariamente a venda que está sendo executada.
    private Venda vendaTemporaria;
    
    public void abrirVenda(String cpfFuncionario, String cpfCliente){ //INCOMPLETO
        //Usuario cliente = buscarCliente(id1) -> buscar cliente por cpf
        //Usuario funcionario = buscarFunc(id2) -> buscar funcionario por cpf
        
        //Caso os usuarios em questão sejam encontrados:
            vendaTemporaria = new Venda();
            vendaTemporaria.setDataVenda(new Date());
            //vendaTemporaria.setCliente(cliente); 
            //vendaTemporaria.setFuncionario(funcionario);
            vendaTemporaria.setValorTotal(0);
    }

    public void adicionarProdutoVenda(long idProduto, int quantidade){ //INCOMPLETO
        //Produto prod = buscarProduto(id);
        ProdutoVenda produtoVenda = new ProdutoVenda(); //BUSCAR PRODUTO
        colecaoVenda.adicionarProdutoVenda(vendaTemporaria, produtoVenda);
        colecaoVenda.calcularValorTotal(vendaTemporaria);
    }

    public void removerProdutoVenda(long idProduto){
        colecaoVenda.removerProdutoVenda(vendaTemporaria, idProduto);
    }

    public void fecharVenda(){ //INCOMPLETO
        colecaoVenda.adicionar(vendaTemporaria);
        //Atualizar o estoque
        vendaTemporaria = null;
    }

    public void cancelarVenda(){
        vendaTemporaria = null;
    }
}
