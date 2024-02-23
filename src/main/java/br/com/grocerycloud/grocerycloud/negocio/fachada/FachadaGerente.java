package br.com.grocerycloud.grocerycloud.negocio.fachada;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoVenda;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Produto;

/** 
 * Esta classe representa a fachada que será utilizada pelos gerentes.
 * @author Arthur de Sá Tenório
 * @category Classe de fachada da aplicação
*/

@Service
public class FachadaGerente {
    @Autowired
    private IColecaoVenda colecaoVenda;
    @Autowired
    private IColecaoAquisicao colecaoAquisicao;
    //NECESSARIO COLECAO DE PRODUTOS, USUARIOS, TROCAS, QUASE TUDO

    //VENDAS

    //AQUISIÇÕES
    public void adicionarAquisicao(String cnpjFornecedor, long idProduto, int qtdeProduto, 
                                   double custo, String dataAquisicao){
        //Buscando produto pelo ID
        Produto produto; //= buscarProduto(id);
        
        //Configurando a data
        Calendar c = Calendar.getInstance();
        String [] dataArray = dataAquisicao.split("-", 0);
        c.set(Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]));
        Date data = c.getTime();

        //Criando a aquisição e adicionando ao repositorio
        //Aquisicao aquisicao = new Aquisicao(dataAquisicao, cnpjFornecedor, produto, qtdeProduto, custo);
        //colecaoAquisicao.adicionar(aquisicao);
        
        //ATUALIZAR ESTOQUE
    }

    public List<Aquisicao> listarAquisicoes(){
        return colecaoAquisicao.listarTodos();
    }
}
