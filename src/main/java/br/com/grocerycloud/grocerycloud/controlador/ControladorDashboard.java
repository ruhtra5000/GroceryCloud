package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;

/**
 * Classe que representa o controlador da Dashboard.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de controlador da aplicação
 */

@Controller
@RequestMapping("/admin/dashboard")
public class ControladorDashboard {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("admin/dashboard/dashboard");

        mv.addObject("maiorAvariado", fachadaGerente.obterProdutoMaisAvariado());
        mv.addObject("totalAvariados", fachadaGerente.obterQtdeTotalAvariados());
        mv.addObject("custoTotalAquisicoes", fachadaGerente.obterCustoTotalAquisicoes());
        mv.addObject("maiorAquisicaoProduto", fachadaGerente.obterProdutoMaisAdquirido());
        mv.addObject("aquisicoes", fachadaGerente.obterAquisicoesAgrupadas());

        return mv;
    }

}
