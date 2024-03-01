package br.com.grocerycloud.grocerycloud.negocio.colecoes;

import java.util.List;
import java.util.Map;

/**
 * Interface que representa o contrado duma Dashbaord, definindo quais métodos
 * serão necessários.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Interface de negócio
 */

public interface IColecaoDashboard {

    // Produtos Avariados
    public long getQtdeTotalAvariados();

    public List<Map<String, Object>> getProdutoMaisAvariado();

     // Aquisições
    public double getCustoTotalAquisicoes();

    public List<Map<String, Object>> getAquisicoesAgrupadas();
    
    public List<Map<String, Object>> getProdutoMaisAdquirido();
}
