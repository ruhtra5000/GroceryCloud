package br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes;

/** 
 * @author Arthur de Sá Tenório
 * @category Classe de exceção da aplicação
*/

public class AquisicaoNaoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;

    public AquisicaoNaoEncontradaException(){
        super("Aquisição não encontrada.");
    }
}
