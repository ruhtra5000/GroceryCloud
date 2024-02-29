package br.com.grocerycloud.grocerycloud.negocio.entidade;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoAquisicao;

@SpringBootTest
public class TesteAquisicao {
    @Autowired
    private IColecaoAquisicao colecaoAquisicao;
    
    @Test
    public void CnpjInvalidoTest(){
        boolean verificacao = colecaoAquisicao.verificarCNPJ("46.745.829/0001-27");
        assertFalse(verificacao);
    }
}
