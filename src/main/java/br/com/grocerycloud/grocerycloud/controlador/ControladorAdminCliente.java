package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.cliente.NomeClienteNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.funcionarios.CpfNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;

/**
 * Esta classe representa o controlador do Cliente.
 * @author João Victor Leite Dos Santos
 * @category Classe de controlador da aplicação
 */
@Controller
@RequestMapping("/admin/cliente")

public class ControladorAdminCliente {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public ModelAndView homeAdminCliente() {
        ModelAndView mv = new ModelAndView("/admin/cliente/cliente");
        mv.addObject("clientes", fachadaGerente.listarClientes());

        return mv;
    }

    @GetMapping("/nome/{nome}")
    public ModelAndView buscarClientePorNome(@PathVariable("nome") String nome) {
        ModelAndView mv = new ModelAndView("/admin/cliente/cliente");
        try {
            mv.addObject("clientes", fachadaGerente.buscarClientePorNome(nome));
        } catch (NomeClienteNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }

    @GetMapping("/cpf/{cpf}")
    public ModelAndView buscarClientePorCpf(@PathVariable("cpf") String cpf) {
        ModelAndView mv = new ModelAndView("/admin/cliente/cliente");
        try {
            mv.addObject("clientes", fachadaGerente.buscarClientePorCpf(cpf));
        } catch (CpfNaoEncontradoException err) {
            mv.setViewName("geral/erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }
}