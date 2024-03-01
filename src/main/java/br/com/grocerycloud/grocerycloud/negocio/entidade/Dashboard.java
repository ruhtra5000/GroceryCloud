package br.com.grocerycloud.grocerycloud.negocio.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 * Classe que representa a Dashboard (painel visual) com a finalidade de
 * conceder informativos aos gerentes do supermercado.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Entidade básica da aplicação
 */

@Entity
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
