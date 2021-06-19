package edu.programacion.central.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class ProductController {

    @GetMapping(path = { "/poloQuick001" })
    public String mostrar1(Model model) {
        return "poloQuick001";
    }

    @GetMapping(path = { "/poloFox001" })
    public String mostrar2(Model model) {
        return "poloFox001";
    }

    @GetMapping(path = { "/poloDunkelvok001" })
    public String mostrar3(Model model) {
        return "poloDunkelvok001";
    }

    @GetMapping(path = { "/teclado" })
    public String mostrar4(Model model) {
        return "teclado";
    }

    @GetMapping(path = { "/laptop002" })
    public String mostrar5(Model model) {
        return "laptop001";
    }

    @GetMapping(path = { "/mouse001" })
    public String mostrar6(Model model) {
        return "mouse001";
    }

    // @GetMapping(path= {"/public"}) public ModelAndView post(){ ModelAndView
    // modelAndView = new ModelAndView(Pagina.HOME); modelAndView.addObject("posts",
    // getPosts()); return modelAndView; }

    // @GetMapping(path = { "/products" })
    // public ModelAndView getPostIndividual(@RequestParam(defaultValue = "1", name
    // = "id", required = false) int id) {
    // ModelAndView modelAndView = new ModelAndView(Pagina.Post);
    // List<Post> postFiltrado = this.getPosts().stream().filter((p) -> {
    // return p.getId() == id;
    // }).collect(Collectors.toList());
    // modelAndView.addObject("post", postFiltrado.get(0));
    // return modelAndView;
    // }

}
