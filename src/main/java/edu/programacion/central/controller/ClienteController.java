package edu.programacion.central.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import edu.programacion.central.model.Cliente;
import edu.programacion.central.model.User;
import edu.programacion.central.repository.ClienteRepository;
import edu.programacion.central.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class ClienteController {
    private static final String INDEX ="cliente/create"; 
    private static String MODEL_CONTACT="client";
    private final ClienteRepository clientsData;
    private final UserRepository userData;

    public ClienteController(ClienteRepository clientsData, UserRepository userData){
        this.clientsData = clientsData;
        this.userData = userData;
    }      

    @GetMapping("/cliente/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Cliente());
        return INDEX;
    }    

    @PostMapping("/cliente/create")
    public String createSubmitForm(Model model, 
        @Valid Cliente objCliente, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro un cliente");
            return INDEX;
        }else{
            User user = objCliente.getUser();
            user.setTipoUsuario("Cliente");
            this.userData.save(user);
            this.userData.flush();
            this.clientsData.save(objCliente);
            model.addAttribute(MODEL_CONTACT, objCliente);
            model.addAttribute("mensaje", "Se registro un cliente");
        }
        return INDEX;
    }
}
