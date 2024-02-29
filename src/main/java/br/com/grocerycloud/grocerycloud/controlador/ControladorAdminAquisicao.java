package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoRegistrarAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.AquisicaoNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjInvalidoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/** 
 * Esta classe representa o controlador de aquisições da gerencia.
 * @author Arthur de Sá Tenório
 * @category Classe de controlador da aplicação
*/

@Controller
@RequestMapping("/admin/aquisicao")
public class ControladorAdminAquisicao {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public ModelAndView homeAquisicao() {
        ModelAndView mv = new ModelAndView("admin/aquisicao/aquisicao");
        mv.addObject("aquisicoes", fachadaGerente.listarAquisicoes());
        return mv;
    }

    @GetMapping("/registro")
    public ModelAndView registroAquisicao() {
        ModelAndView mv = new ModelAndView("admin/aquisicao/cadastroAquisicao");
        return mv;
    }
    
    @PostMapping("/registro")
    public ModelAndView postRegistroAquisicao(RequisicaoRegistrarAquisicao a) {
        ModelAndView mv = new ModelAndView("redirect:/admin/aquisicao/");
        try {
            fachadaGerente.adicionarAquisicao(a.getCnpjFornecedor(), a.getIdProduto(), 
            a.getQtdeProduto(), a.getCusto(), a.getDataAquisicao());
        }
        catch(ProdutoNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        catch(CnpjInvalidoException err2){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err2.getMessage());
        }
        return mv;
    }

    @GetMapping("/id/{id}")
    public ModelAndView buscaAquisicaoID(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("admin/aquisicao/aquisicao");
        try {
            mv.addObject("aquisicoes", fachadaGerente.buscarAquisicaoPorId(id));
        }
        catch(AquisicaoNaoEncontradaException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/cnpj/{cnpj}")
    public ModelAndView buscaAquisicaoCNPJ(@PathVariable("cnpj") String cnpj) {
        cnpj = cnpj.replace('&', '/');
        System.out.println("cnpn: " + cnpj);
        ModelAndView mv = new ModelAndView("admin/aquisicao/aquisicao");
        try {
            mv.addObject("aquisicoes", fachadaGerente.buscarAquisicaoPorCnpj(cnpj));
        }
        catch(CnpjNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

}
