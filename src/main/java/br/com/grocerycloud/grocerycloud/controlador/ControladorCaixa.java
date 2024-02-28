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
        ModelAndView mv = new ModelAndView("caixa/venda");
        try {
            fachadaCaixa.adicionarProdutoVenda(r.getId(), r.getQuantidade());
            mv.addObject("produtos", fachadaCaixa.listarProdutosVenda());
            mv.addObject("valorTotal", fachadaCaixa.retornarValorTotal());
        }
        catch(ProdutoNaoEncontradoException err){
           mv.setViewName("geral/erro");
           mv.addObject("erro", err.getMessage());
        }
        catch(ProdutoInsuficienteException err2){
           mv.setViewName("geral/erro");
           mv.addObject("erro", err2.getMessage());
        }
        return mv;
    }

    @PostMapping("/venda/remove")
    public ModelAndView removerProdutoVenda(RequisicaoRemoverProdutoVenda r) {
        ModelAndView mv = new ModelAndView("caixa/venda");
        try {
            fachadaCaixa.removerProdutoVenda(r.getIdRemocao());
            mv.addObject("produtos", fachadaCaixa.listarProdutosVenda());
            mv.addObject("valorTotal", fachadaCaixa.retornarValorTotal());
        }
        catch(ProdutoNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/venda/fechar")
    public ModelAndView fecharVenda() {
        ModelAndView mv = new ModelAndView("redirect:/caixa/");
        try {
            fachadaCaixa.fecharVenda();
        }
        catch(ProdutoNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/venda/cancelar")
    public ModelAndView cancelarVenda() {
        ModelAndView mv = new ModelAndView("redirect:/caixa/");
        fachadaCaixa.cancelarVenda();
        return mv;
    }
}
