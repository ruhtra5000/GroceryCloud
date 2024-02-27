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
        ModelAndView mv = new ModelAndView("/admin/funcionario/funcionario");
        mv.addObject("funcionarios", fachadaGerente.listarFuncionarios());

        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionarFuncionario() {
        ModelAndView mv = new ModelAndView("/admin/funcionario/adicionarfuncionario");
        return mv;
    }
    
    @PostMapping("/adicionar")
    public ModelAndView adicionarFuncionarioFunction(RequisicaoAdicionarFuncionario r) {
        fachadaGerente.adicionarFuncionario(r.getNome(), r.getCpf(), r.getTelefone(), r.getEmail(), r.getSenha(), r.getTipoAcesso());
        
        ModelAndView mv = new ModelAndView("redirect:/admin/funcionario/");
        return mv;
    }

    @GetMapping("/cpf/{cpf}")
    public ModelAndView buscarFuncionarioPorCpf(@PathVariable("cpf") String cpf) {
        ModelAndView mv = new ModelAndView("/admin/funcionario/funcionario");
        try {
            mv.addObject("funcionarios", fachadaGerente.buscarFuncionarioPorCpf(cpf));
        }
        catch(CpfNaoEncontradoException err){
             mv.setViewName("geral/erro");
             mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }

    @GetMapping("/nome/{nome}")
    public ModelAndView buscarFuncionarioPorNome(@PathVariable("nome") String nome) {
        ModelAndView mv = new ModelAndView("/admin/funcionario/funcionario");
        try {
            mv.addObject("funcionarios", fachadaGerente.buscarFuncionarioPorNome(nome));
        }
        catch(NomeNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }

    @GetMapping("/atualizar/{cpf}")
    public ModelAndView atualizarFuncionario(@PathVariable("cpf")String cpf) {
        ModelAndView mv = new ModelAndView("/admin/funcionario/editarfuncionario");
        try {
            mv.addObject("funcionario", fachadaGerente.buscarFuncionarioPorCpf(cpf));
        }
        catch(CpfNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }

    @PostMapping("/atualizar")
      public ModelAndView atualizarFuncionarioFunction(RequisicaoAdicionarFuncionario r) {
        ModelAndView mv = new ModelAndView("redirect:/admin/funcionario/");
        try {
            fachadaGerente.atualizarFuncionario(r.getId(), r.getNome(), r.getCpf(), r.getTelefone(), r.getEmail(), r.getSenha(), r.getTipoAcesso());
        }
        catch(FuncionarioNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());   
        }
        return mv;
    }

}
