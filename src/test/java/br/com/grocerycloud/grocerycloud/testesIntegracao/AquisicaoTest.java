package br.com.grocerycloud.grocerycloud.testesIntegracao;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/** 
 * Esta classe busca testar o repositorio de aquisições
 * @author Arthur de Sá Tenório
 * @category Classe de teste
*/

@SpringBootTest
public class AquisicaoTest {
    @Autowired
    private IRepositorioAquisicao repositorioAquisicao;
    @Autowired
    private FachadaGerente fachadaGerente;

    @Test
    public void cadastroAquisicaoTest() {
        long l = 1;
        
        long qtdeAquisicoes = repositorioAquisicao.count();
        try {
            fachadaGerente.adicionarAquisicao("91.827.947/0001-26", l, 3, 25.0, "2024-03-21");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        long qtdeAquisicoes2 = repositorioAquisicao.count();
        assertEquals(qtdeAquisicoes2, qtdeAquisicoes+1);
    }
}
