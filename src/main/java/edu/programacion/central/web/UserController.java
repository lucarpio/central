package edu.programacion.central.web;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;



import org.springframework.ui.Model;

//import edu.programacion.central.domain.Persona;
import edu.programacion.central.repository.UserRepository;
import java.util.Optional;
import edu.programacion.central.domain.User;
//import edu.programacion.central.repository.IPersonaRepo;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;


@Controller
public class UserController {
    

    private final UserRepository userData;
    private static final String MESSAGE_ATTRIBUTE = "message"; 
    private static final String USER_INDEX ="user/index";
    private static final String HOME_INDEX ="/index";

    public UserController(UserRepository userData){
        this.userData = userData;
    }

   
    //private IPersonaRepo repo;

    @GetMapping("/user/login")
    public String index(Model model) {
        User usuario = new User();
        model.addAttribute("user", usuario);
        return USER_INDEX;
    }

  
    
    @PostMapping("/user/login")
    public String login(Model model,
        @Valid User objUser, BindingResult result 
        ){
        String page;
        if(result.hasFieldErrors()) {
            model.addAttribute(MESSAGE_ATTRIBUTE, "Ingrese la informacion mandatoria");
            page = USER_INDEX;
        }else{
           Optional<User> userDB = this.userData.findById(objUser.getUsername());
           if(userDB.isPresent()){
                if(objUser.getPassword().equals(userDB.get().getPassword())){
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Ingreso Satisfactorio");
                    page = HOME_INDEX;
                }else{
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Password no coincide");
                    page = USER_INDEX;
                }
           }else{
                model.addAttribute(MESSAGE_ATTRIBUTE, "Usuario no existe");
                page = USER_INDEX;
           }
        }
        return page;

    }
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
