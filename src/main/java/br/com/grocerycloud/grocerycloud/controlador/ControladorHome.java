package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoLogin;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Funcionario;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Usuario;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.login.UsuarioNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaCliente;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorHome {
    @Autowired
    private FachadaCliente fachadaCliente;

    @GetMapping("/")
    public ModelAndView homeGeral() {
        ModelAndView mv = new ModelAndView("geral/index");
        return mv;
    }
    
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("geral/login");
        return mv;
    }
    
    @PostMapping("/login")
    public ModelAndView realizarLogin(RequisicaoLogin r) {
        ModelAndView mv = new ModelAndView();
        try {
            Usuario usuario = fachadaCliente.buscarUsuario(r.getCpf(), r.getSenha());
            if(usuario instanceof Funcionario){
                if(((Funcionario) usuario).getTipoAcesso() == 0){
                    mv.setViewName("redirect:/caixa/");
                }
                else if(((Funcionario) usuario).getTipoAcesso() == 1){
                    mv.setViewName("redirect:/admin/");
                }
            }
            else if(usuario instanceof Cliente){
                mv.setViewName("redirect:/");
            }
        }
        catch(UsuarioNaoEncontradoException err){
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }
    
}