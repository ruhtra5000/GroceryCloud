package br.com.grocerycloud.grocerycloud.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoCriarOuvidoria;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.cliente.ClienteNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.UsuarioSemVendasException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaCliente;


/** 
 * Esta classe representa o controlador do cliente.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de controlador da aplicação
*/

@Controller
@RequestMapping("/cliente")
public class ControladorCliente {
    @Autowired
    private FachadaCliente fachadaCliente;

    @GetMapping("/")
    public ModelAndView homeCliente() {
        ModelAndView mv = new ModelAndView("/cliente/menuCliente");
        return mv;
    }
    
    @GetMapping("/ouvidoria")
    public ModelAndView adicionarOuvidoria() {
        ModelAndView mv = new ModelAndView("/cliente/criarouvidoria");
        return mv;
    }

    @PostMapping("/ouvidoria/registro") 
    public ModelAndView registrarOuvidoriaFunction(RequisicaoCriarOuvidoria r) throws ClienteNaoEncontradoException {
        ModelAndView mv = new ModelAndView("redirect:/cliente/ouvidoria");
        try {
            fachadaCliente.criarOuvidoria(r.getId(), r.getMensagem());
        }
        catch(ClienteNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }

    @PostMapping("/ouvidoria")
    public ModelAndView adicionaroOuvidoriaFunction(RequisicaoCriarOuvidoria r) throws ClienteNaoEncontradoException {
        ModelAndView mv = new ModelAndView("redirect:/cliente/");     
        fachadaCliente.criarOuvidoria(r.getId(), r.getMensagem());
        return mv;
    }


    /** 
     * Metodos de histórico de venda e atualização de vínculo
     * @author Arthur de Sá Tenório
    */

    @GetMapping("/historico")
    public ModelAndView abrirHistorico() {
        ModelAndView mv = new ModelAndView("/cliente/abrirHistorico");
        return mv;
    }

    @GetMapping("/historico/{cpf}")
    public ModelAndView visualizarHistorico(@PathVariable("cpf") String cpf) {
        ModelAndView mv = new ModelAndView("/cliente/historicoVenda");
        try {
            mv.addObject("vendas", fachadaCliente.visualizarHistoricoDeCompras(cpf));
        }
        catch(CpfNaoEncontradoException|UsuarioSemVendasException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }
    
    @GetMapping("/vinculo")
    public ModelAndView atualizarVinculo() {
        ModelAndView mv = new ModelAndView("/cliente/atualizarVinculo");
        return mv;
    }

    @GetMapping("/vinculo/{cpf}")
    public ModelAndView atualizarVinculoFunction(@PathVariable("cpf") String cpf) {
        ModelAndView mv = new ModelAndView("redirect:/cliente/");
        try {
            fachadaCliente.atualizarVinculo(cpf);
        }
        catch(CpfNaoEncontradoException|ClienteNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }
    
}
