package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoAbrirVenda;
import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoAdicionarProdutoVenda;
import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoRemoverProdutoVenda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.vendas.ProdutoInsuficienteException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaCaixa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



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
    public ModelAndView abrirVenda(RequisicaoAbrirVenda r) {
        fachadaCaixa.abrirVenda(r.getCpfFuncionario(), r.getCpfCliente());
        ModelAndView mv = new ModelAndView("caixa/venda");
        mv.addObject("produtos", fachadaCaixa.listarProdutosVenda());
        mv.addObject("valorTotal", fachadaCaixa.retornarValorTotal());
        return mv;
    }

    @PostMapping("/venda/add")
    public ModelAndView adicionarProdutoVenda(RequisicaoAdicionarProdutoVenda r) {
        try {
            fachadaCaixa.adicionarProdutoVenda(r.getId(), r.getQuantidade());
            ModelAndView mv = new ModelAndView("caixa/venda");
            mv.addObject("produtos", fachadaCaixa.listarProdutosVenda());
            mv.addObject("valorTotal", fachadaCaixa.retornarValorTotal());
            return mv;
        }
        catch(ProdutoNaoEncontradoException err){
            System.out.println(err.getMessage());
        }
        catch(ProdutoInsuficienteException err2){
            System.out.println(err2.getMessage());
        }
        return null;
    }

    @PostMapping("/venda/remove")
    public ModelAndView removerProdutoVenda(RequisicaoRemoverProdutoVenda r) {
        try {
            fachadaCaixa.removerProdutoVenda(r.getIdRemocao());
            ModelAndView mv = new ModelAndView("caixa/venda");
            mv.addObject("produtos", fachadaCaixa.listarProdutosVenda());
            mv.addObject("valorTotal", fachadaCaixa.retornarValorTotal());
            return mv;
        }
        catch(ProdutoNaoEncontradoException err){
            System.out.println(err.getMessage());
        }
        return null;
    }

    @GetMapping("/venda/fechar")
    public String fecharVenda() {
        try {
            fachadaCaixa.fecharVenda();
        }
        catch(ProdutoNaoEncontradoException err){
            System.out.println(err.getMessage());
        }
        return "redirect:/caixa/";
    }

    @GetMapping("/venda/cancelar")
    public String cancelarVenda() {
        fachadaCaixa.cancelarVenda();
        return "redirect:/caixa/";
    }
    
    
    
}
