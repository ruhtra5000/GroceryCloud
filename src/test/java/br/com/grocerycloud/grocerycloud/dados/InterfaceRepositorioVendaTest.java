package br.com.grocerycloud.grocerycloud.dados;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InterfaceRepositorioVendaTest {
    @Autowired
    private InterfaceRepositorioVenda repositorioVenda;

    @Test
    public void cadastroVendaTest(){
        long qtde = repositorioVenda.count();
        
        //Terminar (QUANDO HOUVER REPOSITORIO DE PRODUTOS)
    }
}
