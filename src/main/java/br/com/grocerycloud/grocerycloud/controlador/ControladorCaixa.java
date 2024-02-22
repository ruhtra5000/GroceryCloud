package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoAbrirVenda;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaCaixa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

/** 
 * Esta classe representa o controlador do caixa.
 * @author Arthur de Sá Tenório
 * @category Classe de controlador da aplicação
*/

@Controller
@RequestMapping("/caixa")
public class ControladorCaixa {
    @Autowired
    private FachadaCaixa fachadaCaixa;

    @GetMapping("/")
    public String homeCaixa() {
        return "caixa/abrirVenda";
    }
    
    @PostMapping("/venda")
    public String abrirVenda(RequisicaoAbrirVenda r) {
        fachadaCaixa.abrirVenda(r.getCpfFuncionario(), r.getCpfCliente());
        return "caixa/venda";
    }
    
}
