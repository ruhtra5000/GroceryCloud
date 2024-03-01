package br.com.grocerycloud.grocerycloud.negocio.entidade;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoProduto;

/**
 * Método de teste de unidade de produto
 * 
 * @author Guilherme Paes Cavalcanti
 */
@SpringBootTest
public class TesteProduto {

    @Autowired
    IColecaoProduto colecaoProduto;

    @Test
    public void temDescontoTest() {
        Produto p = new Produto("n", "c", 1, 1, 0.5);
        boolean teste = colecaoProduto.temDesconto(p);
        assertTrue(teste);
    }

}
