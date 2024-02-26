package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/admin")
public class ControladorAdmin {
    
    @GetMapping("/")
    public ModelAndView homeAdmin() {
        ModelAndView mv = new ModelAndView("admin/menuAdmin");
        return mv;
    }
    
}
