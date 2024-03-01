package br.com.grocerycloud.grocerycloud.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoCriarOuvidoria;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.cliente.ClienteNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaCliente;

/** 
 * Esta classe representa o controlador de Ouvidoria.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de controlador da aplicação
*/

@Controller
@RequestMapping("/cliente")

public class ControladorCliente {

    @Autowired
    private FachadaCliente fachadaCliente;
    
    @GetMapping("/ouvidoria")
    public ModelAndView adicionarOuvidoria() {
        ModelAndView mv = new ModelAndView("/cliente/ouvidoria/");
        return mv;
    }
    
    @PostMapping("/ouvidoria")
    public ModelAndView adicionaroOuvidoriaFunction(RequisicaoCriarOuvidoria r) throws ClienteNaoEncontradoException {
        ModelAndView mv = new ModelAndView("redirect:/cliente/ouvidoria/");
            fachadaCliente.criarOuvidoria(r.getId(), r.getMensagem());;
        return mv;
    }

    
}
