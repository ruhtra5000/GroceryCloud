package br.com.grocerycloud.grocerycloud.dados;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class InterfaceRepositorioAquisicaoTest {
    @Autowired
    private InterfaceRepositorioAquisicoes repositorioAquisicoes;

    @Test
    public void cadastroAquisicaoTest(){
        long qtdeAquisicoes = repositorioAquisicoes.count();
        //Terminar (QUANDO HOUVER REPOSITORIO DE PRODUTOS)
    }
}
