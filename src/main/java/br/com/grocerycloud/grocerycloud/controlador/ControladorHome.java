package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorHome {

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
    public String realizarLogin() { //INCOMPLETO
        
        return "entity";
    }
    
}