package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoRegistrarProduto;
import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoRegistrarProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.AvariadoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.CategoriaNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.NomeNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoJaRegistradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.ProdutoNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.QuantidadeProdutoInsuficienteException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Classe que representa o controlador dos produtos e avariados da gerência.
 * 
 * @author Guilherme Paes Cavalcanti
 * @category Classe de controlador da aplicação
 */

@Controller
@RequestMapping("/admin/estoque")
public class ControladorAdminProduto {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public ModelAndView homeProduto() {
        ModelAndView mv = new ModelAndView("admin/produto/estoque");
        mv.addObject("produtos", fachadaGerente.listarProdutos());
        return mv;
    }

    // Registro
    @GetMapping("/registro")
    public ModelAndView registroProduto() {
        ModelAndView mv = new ModelAndView("admin/produto/cadastroProduto");
        mv.addObject("produtos");
        return mv;
    }

    @PostMapping("/registro")
    public ModelAndView postRegistroProduto(RequisicaoRegistrarProduto req) {
        ModelAndView mv = new ModelAndView("redirect:/admin/estoque/");
        try {
            fachadaGerente.adicionarProduto(req.getNome(), req.getCategoria(), req.getQtde(),
                    req.getPreco());
        } catch (ProdutoJaRegistradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }

        return mv;
    }

    @GetMapping("/id/{id}")
    public ModelAndView buscarProdutoID(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("admin/produto/estoque");
        try {
            mv.addObject("produtos", fachadaGerente.listarProdutoPorId(id));
        } catch (ProdutoNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/nome/{nome}")
    public ModelAndView buscarProdutoNome(@PathVariable("nome") String nome) {
        ModelAndView mv = new ModelAndView("admin/produto/estoque");
        try {
            mv.addObject("produtos", fachadaGerente.listarProdutoPorNome(nome));
        } catch (NomeNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/categoria/{categoria}")
    public ModelAndView buscarProdutoCategoria(@PathVariable("categoria") String categoria) {
        ModelAndView mv = new ModelAndView("admin/produto/estoque");
        try {
            mv.addObject("produtos", fachadaGerente.listarProdutoPorCategoria(categoria));
        } catch (CategoriaNaoEncontradaException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView atualizarProduto(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("admin/produto/editarProduto");
        try {
            mv.addObject("produto", fachadaGerente.listarProdutoPorId(id));
        } catch (ProdutoNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @PostMapping("/atualizar")
    public ModelAndView postAtualizarProduto(RequisicaoRegistrarProduto req) {
        ModelAndView mv = new ModelAndView("redirect:/admin/estoque/");
        try {
            fachadaGerente.atualizarProduto(req.getId(), req.getNome(), req.getCategoria(), req.getQtde(),
                    req.getPreco(),
                    req.getPrecoDesconto());
        } catch (ProdutoNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    // Avariados
    @GetMapping("/avariados")
    public ModelAndView homeProdutoAvariado() {
        ModelAndView mv = new ModelAndView("admin/produto/avariados");
        mv.addObject("avariados", fachadaGerente.listarProdutosAvariados());
        return mv;
    }

    @GetMapping("/avariados/id/{id}")
    public ModelAndView buscarProdutoAvariadoID(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("admin/produto/avariados");
        try {
            mv.addObject("avariados", fachadaGerente.listarProdutoAvariadoPorId(id));
        } catch (AvariadoNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/avariados/idProduto/{idProduto}")
    public ModelAndView buscarProdutoAvariadoIdProduto(@PathVariable("idProduto") long id) {
        ModelAndView mv = new ModelAndView("admin/produto/avariados");
        try {
            mv.addObject("avariados", fachadaGerente.listarProdutosAvariadosPorIdProduto(id));
        } catch (AvariadoNaoEncontradoException | ProdutoNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/avariados/registro/{id}")
    public ModelAndView registroProdutoAvariado(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("admin/produto/cadastroAvariado");
        try {
            mv.addObject("produto", fachadaGerente.listarProdutoPorId(id));
        } catch (ProdutoNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @PostMapping("/avariados/registro")
    public ModelAndView postRegistroProdutoAvariado(RequisicaoRegistrarProdutoAvariado req) {
        ModelAndView mv = new ModelAndView("redirect:/admin/estoque/avariados");

        try {

            fachadaGerente.adicionarProdutoAvariado(req.getId(), req.getQtdeAvariados(), req.getDataAvariado());

        } catch (ProdutoNaoEncontradoException | QuantidadeProdutoInsuficienteException err) {

            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());

        }

        return mv;
    }

}
