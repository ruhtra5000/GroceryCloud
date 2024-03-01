package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.ouvidoria.ClienteNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.ouvidoria.OuvidoriaNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;

/** 
 * Esta classe representa o controlador de Ouvidoria.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de controlador da aplicação
*/
@Controller
@RequestMapping("/admin/ouvidoria")

public class ControladorAdminOuvidoria {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public ModelAndView homeAdminOuvidoria() {
        ModelAndView mv = new ModelAndView("/admin/ouvidoria/ouvidoria");
        mv.addObject("ouvidoria", fachadaGerente.listarTodos());
        return mv;
    }

    @GetMapping("/id/{id}")
    public ModelAndView listarPorId(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("/admin/ouvidoria/ouvidoria");
        try {
            mv.addObject("ouvidoria", fachadaGerente.buscarPorId(id));
        }
        catch(OuvidoriaNaoEncontradaException err){
             mv.setViewName("geral/erro");
             mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }

    @GetMapping("/cliente/{cliente}")
    public ModelAndView listarPorCliente(@PathVariable("cliente") Cliente cliente) {
        ModelAndView mv = new ModelAndView("/admin/ouvidoria/ouvidoria");
        try {
            mv.addObject("ouvidoria", fachadaGerente.buscarPorCliente(cliente));
        }
        catch(ClienteNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }

}
