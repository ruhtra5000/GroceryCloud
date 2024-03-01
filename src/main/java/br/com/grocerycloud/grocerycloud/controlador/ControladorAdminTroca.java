package br.com.grocerycloud.grocerycloud.controlador;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.troca.TrocaNaoEncontrada;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Classe que representa o controlador dos troca.
 * 
 * @author João Victor Leite Dos Santos
 * @category Classe de controlador da aplicação
 */

@Controller
@RequestMapping("/admin/troca")
public class ControladorAdminTroca {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public ModelAndView homeProduto() {
        ModelAndView mv = new ModelAndView("admin/produto/troca");
        mv.addObject("trocas", fachadaGerente.listarTrocas());
        return mv;
    }

    @GetMapping("/id/{id}")
    public ModelAndView buscarProdutoID(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("admin/produto/troca");
        try {
            mv.addObject("trocas", fachadaGerente.buscarId(id));
        } catch (TrocaNaoEncontrada err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }
    @PostMapping("/adicionar")
    public ModelAndView postAdicionarTroca(ProdutoAvariado produtoAvariado, Date date) {
        ModelAndView mv = new ModelAndView("redirect:/admin/troca/");
            fachadaGerente.adicionarTroca(produtoAvariado, date);

        return mv;
    }
}
