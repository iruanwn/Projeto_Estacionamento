
package com.senac.Estacionamentoweb.Controller;

import com.senac.Estacionamentoweb.Data.ClienteEntity;
import com.senac.Estacionamentoweb.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
 @Autowired 
ClienteService clienteService; 

         @GetMapping("/") 
    public String viewHomePage(Model model) { 
    model.addAttribute("listarClientes", clienteService.listarTodosClientes()); 
    return "index"; 
}
        @GetMapping("/criarCliente") 
    public String criarlienteForm(Model model) { 
    ClienteEntity cliente = new ClienteEntity(); 
    model.addAttribute("cliente", cliente); 
    return "inserir"; 
} 
        @GetMapping("/deletarCliente/{id}") 
    public String deletarCliente(@PathVariable(value = "id") Integer id) { 
    clienteService.deletarCliente(id);
    return "redirect:/"; 
}
        @PostMapping("/salvarCliente") 
public String salvarCliente( @ModelAttribute ClienteEntity cliente, BindingResult result) { 
    if (cliente.getId()==null) {
        clienteService.criarCliente(cliente);
    } else { 
        clienteService.atualizarCliente(cliente.getId(), cliente);
 } 
 return "redirect:/"; 
} 
@GetMapping("/atualizarClienteForm/{id}") 

public String atualizarClienteForm(@PathVariable(value = "id") Integer id, Model model) { 

ClienteEntity cliente = clienteService.getclienteId(id);

model.addAttribute("cliente", cliente); 

return "atualizar"; 
} 
}


