package br.com.grocerycloud.grocerycloud.negocio.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.InterfaceRepositorioVenda;

@Service
public class FachadaCaixa {
    @Autowired
    private InterfaceRepositorioVenda repositorioVenda;
}
