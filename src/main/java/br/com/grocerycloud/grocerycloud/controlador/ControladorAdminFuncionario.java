package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoAdicionarFuncionario;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.FuncionarioNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.produtos.NomeNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;

/** 
 * Esta classe representa o controlador do Funcionario.
 * @author Victor Cauã Tavares Inácio
 * @category Classe de controlador da aplicação
*/

@Controller
@RequestMapping("/admin/funcionario")

public class ControladorAdminFuncionario {

    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public ModelAndView homeAdminFuncionario() {
    
        ModelAndView Mv = new ModelAndView("/admin/funcionario/funcionario");
        Mv.addObject("funcionarios", fachadaGerente.listarFuncionarios());

        return Mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionarFuncionario() {
    
        ModelAndView Mv = new ModelAndView("/admin/funcionario/adicionarfuncionario");

        return Mv;
    
    }
    
    @PostMapping("/adicionar")
    public ModelAndView adicionarFuncionarioFunction(RequisicaoAdicionarFuncionario r) {

        ModelAndView Mv = new ModelAndView("redirect:/admin/funcionario/");

        fachadaGerente.adicionarFuncionario(r.getNome(), r.getCpf(), r.getTelefone(), r.getEmail(), r.getSenha(), r.getTipoAcesso());

        return Mv;
    
    }

    @GetMapping("/cpf/{cpf}")
    public ModelAndView buscarFuncionarioPorCpf(@PathVariable("cpf")String cpf) {
    
        ModelAndView Mv = new ModelAndView("/admin/funcionario/funcionario");
        try{
        Mv.addObject("funcionarios", fachadaGerente.buscarFuncionarioPorCpf(cpf));
        }
        catch(CpfNaoEncontradoException err){
             Mv.setViewName("geral/erro");
             Mv.addObject("erro", err.getMessage());   
        }
        return Mv;
    
    }

    @GetMapping("/nome/{nome}")
    public ModelAndView buscarFuncionarioPorNome(@PathVariable("nome")String nome) {
    
        ModelAndView Mv = new ModelAndView("/admin/funcionario/funcionario");
        try{
        Mv.addObject("funcionarios", fachadaGerente.buscarFuncionarioPorNome(nome));
        }
        catch(NomeNaoEncontradoException err){
             Mv.setViewName("geral/erro");
             Mv.addObject("erro", err.getMessage());   
        }
        return Mv;
    
    }

    @GetMapping("/atualizar/{cpf}")
    public ModelAndView atualizarFuncionario(@PathVariable("cpf")String cpf) {
    
        ModelAndView Mv = new ModelAndView("/admin/funcionario/editarfuncionario");
        try{
        Mv.addObject("funcionario", fachadaGerente.buscarFuncionarioPorCpf(cpf));
        }
        catch(CpfNaoEncontradoException err){
             Mv.setViewName("geral/erro");
             Mv.addObject("erro", err.getMessage());   
        }
        return Mv;
    
    }

    @PostMapping("/atualizar")
      public ModelAndView atualizarFuncionarioFunction(RequisicaoAdicionarFuncionario r) {
    
        ModelAndView Mv = new ModelAndView("redirect:/admin/funcionario/");
        try{
        fachadaGerente.atualizarFuncionario(r.getId(), r.getNome(), r.getCpf(), r.getTelefone(), r.getEmail(), r.getSenha(), r.getTipoAcesso());
        }
        catch(FuncionarioNaoEncontradoException err){
             Mv.setViewName("geral/erro");
             Mv.addObject("erro", err.getMessage());   
        }
        return Mv;

    }


}
