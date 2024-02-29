package br.com.grocerycloud.grocerycloud.negocio.excecoes.troca;

/**
 * @author João Victor Leite Dos Santos
 * @category Classe de exceção da aplicação
 */

public class TrocaNaoEncontrada extends Exception {

        private static final long serialVersionUID = 1L;
        public TrocaNaoEncontrada(){
            super("Troca não encontrada.");
        }
}
