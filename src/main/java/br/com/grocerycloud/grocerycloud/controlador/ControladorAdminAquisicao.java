package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin/aquisicao")
public class ControladorAdminAquisicao {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public String home() {
        return "admin/aquisicao/aquisicao";
    }
    
}
