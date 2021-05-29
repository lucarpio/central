package edu.programacion.central.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

//import java.util.Optional;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import edu.programacion.central.model.Contact;
import edu.programacion.central.repository.ContactRepository;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository repo;
    
    private final ContactRepository contactData;
    private static final String CONTACT_CREATE = "contact/create";

    public ContactController(ContactRepository contactData) {
        this.contactData = contactData;
    }

    @GetMapping("/contact/create")
    public String index(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return CONTACT_CREATE;
    }

    @PostMapping("/contact/create")
    public String submitCreationForm(Model model,
        @Valid Contact objContact, BindingResult result) {
        if (!result.hasErrors()) {
            model.addAttribute("message", "Se registro satisfactoriamente");
            this.contactData.save(objContact);
        }else{
            model.addAttribute("message", "Por favor envie los datos correctos");
        }
        return CONTACT_CREATE;
    }

    @GetMapping("/contact/listar")
    public String listar (Model model){
        //lógica
        model.addAttribute("contacts", repo.findAll());
        return "contact/listar";
    }


}