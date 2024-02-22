package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;
import org.springframework.web.bind.annotation.GetMapping;

/** 
 * Esta classe representa o controlador de venda da gerencia.
 * @author Arthur de Sá Tenório
 * @category Classe de controlador da aplicação
*/

@Controller
@RequestMapping("/admin/venda")
public class ControladorAdminVenda {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public String home() {
        return "admin/venda/vendas";
    }
    
}
