package edu.programacion.central.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.programacion.central.model.Usuario;
import edu.programacion.central.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("usuarios", new Usuario());
        return "form";
    }

    /*
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Usuario usuario, BindingResult result,
        Model model, @RequestParam("file") MultipartFile imagen, RedirectAttributes attributes){

        }
    
    @PostMapping("/")
    public String guardar(@RequestParam("file") MultipartFile foto, Usuario usuario,
            RedirectAttributes attribute){
        if(!foto.isEmpty()){
            String ruta = "C://Temp//uploads";

            try {
                byte[] bytes = foto.getBytes();
                Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
                Files.write(rutaAbsoluta, bytes);
                usuario.setFoto(foto.getOriginalFilename());
            } catch (Exception e) {
                //TODO: handle exception
            }

            usuarioRepo.save(usuario);
            attribute.addFlashAttribute("succes", "Foto subida!!");
        }
        return "redirect:/";
    }

    */
    
    @PostMapping("/usuario/guardar")
    public String guardar(@RequestParam("file") MultipartFile foto, Usuario usuario, BindingResult result,
            RedirectAttributes attribute){
        
        if(!foto.isEmpty()){
            //String ruta = "C://Temp//uploads";
            Path directorioImagenes = Paths.get("src//main//resources//static//img");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg = foto.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + foto.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                usuario.setFoto(foto.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }

            usuarioRepo.save(usuario);
            attribute.addFlashAttribute("success", "Foto subida!!");
        }
        return "redirect:/usuario/registrar";
    }



    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("usuarios", usuarioRepo.findAll());
        return "listar";
    }
    
}
