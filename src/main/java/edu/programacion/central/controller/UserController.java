package edu.programacion.central.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;



import org.springframework.ui.Model;

import edu.programacion.central.model.User;
//import edu.programacion.central.domain.Persona;
import edu.programacion.central.repository.UserRepository;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
//import edu.programacion.central.repository.IPersonaRepo;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;


@Controller
public class UserController {
private static final String MESSAGE_ATTRIBUTE = "message"; 
    private static final String USER_INDEX ="user/index";
    private static final String HOME_INDEX ="/index";
    private static String USER_MODEL="user";
    private final UserRepository userData;

    public UserController(UserRepository userData){
        this.userData = userData;
    }

   
    //private IPersonaRepo repo;

    @GetMapping("/user/login")
    public String index(Model model) {
        model.addAttribute(USER_MODEL, new User());
        return USER_INDEX;
    }

    @PostMapping("/user/login")
    public String login(Model model, @Valid User objUser, HttpServletRequest request, BindingResult result){
        String page=USER_INDEX;
        model.addAttribute(USER_MODEL, new User());
        if(result.hasFieldErrors()) {
            model.addAttribute(MESSAGE_ATTRIBUTE, "Error al ingresar su usuario o contraseña");
        }else{
           Optional<User> userDB = this.userData.findById(objUser.getUsername());
           if(userDB.isPresent()){
                if(userDB.get().getPassword().equals(objUser.getPassword())){
                    model.addAttribute(USER_MODEL,userDB.get());
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Usuario existe");
                    request.getSession().setAttribute("user", objUser);
                    page="welcome";  
                }else{
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Password no coincide");  
                }
           }else{
                model.addAttribute(MESSAGE_ATTRIBUTE, "Usuario no existe");
           }
        }
        return page;
    }



    @GetMapping("/user/logout")
	public String logoutSession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}

    
    /*
    @PostMapping("/usuario/login")
    public String loginSubmitForm(Model model,@Valid Usuario objUser, HttpServletRequest request,
         BindingResult result ){

        String page=INDEX;
        model.addAttribute(MODEL_CONTACT, new Usuario());
        if(result.hasFieldErrors()) {
            model.addAttribute(MODEL_MESSAGE, "No se ha podido loguear");
        }else{
            Optional<Usuario> userDB = this.usuariosData.findById(objUser.getUserID());
            if(userDB.isPresent()){
                if(userDB.get().getPassword().equals(objUser.getPassword())){
                    model.addAttribute(MODEL_CONTACT,userDB.get());
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Usuario existe");
                    request.getSession().setAttribute("user", objUser);
                    page="welcome";  
                }else{
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Password no coincide");  
                }
            }else{
                model.addAttribute(MESSAGE_ATTRIBUTE, "Usuario no existe");
            }
        }
        return page;
    }
    */
/*
    @GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        //lógica
        Persona p = new Persona(1, "alvaro");
        repo.save(p);
		model.addAttribute("name", name);
		return "greeting";
	}

    @GetMapping("/listar")
    public String greeting (Model model){
        //lógica
        model.addAttribute("personas", repo.findAll());
        return "greeting";
    }

*/
}
