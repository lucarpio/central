package edu.programacion.central.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.programacion.central.model.Product;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    public List<Product> getProducts() {

        ArrayList<Product> product = new ArrayList<>();

        product.add(new Product(1, "RAZER TECLADO ORNATA V2", 399.90,
                "Certificación: MSDS Teclado de tamaño completo: si Características: Teclas multimedia Estilo de operación: Membrana Interfaz de unidad: USB 2.0 Tipo: Cableado Tipo de interfaz: USB Estándar del teclado: 104 llaves Estado de los productos: Nuevo Solicitud: Escritorio Número de modelo: V4 Nombre del producto: Teclado retroiluminado USB con cable Color: Negro Material: ABS - Resistente a líquidos -Impermeable."));
        product.add(new Product(2, "Microsoft Mouse BLUETOOTH BLACK", 99.90,
                "Este mouse facilita el desplazamiento y la exploración de documentos extensos o páginas web con amplia información. Es el acompañante perfecto para tu laptop o desktop. ¡La tecnología que buscabas!"));
        product.add(new Product(3, "ASUS LAPTOP VIVOBOOK S14 M433UA 14\" RYZEN 5 512GB 8GB - NEGRO", 3999.90,
                "Laptop M433UA-EB045T de Asus. Procesador AMD Ryzen 5 5500U. 8GB de memoria RAM. Almacenamiento en estado sólido de 512GB."));
        product.add(new Product(4, "QUIKSILVER POLO MC QS-00066", 60.00,
                "Traemos para tí lo mejor de la nueva temporada de Quiksilver. Prendas fabricadas con los más altos estándares de calidad, para asegurarte gran comodidad y duración aparte de sus grandiosos diseños que podrás lucir cuando quieras de manera fresca y original."));
        product.add(new Product(5, "FOX POLO MANGA CORTA LEGACY MOTH", 69.00,
                "Este polo cuenta con un diseño casual y versátil; se convertirá en tu perfecto aliado por su practicidad y ligereza."));
        product.add(new Product(6, "DUNKELVOLK POLO WILD MOUNTAIN", 49.00,
                "Si quieres vestir con un estilo súper cool y lleno de carácter Dunkelvolk tiene lo que necesitas. ¡Déjate sorprender por sus exclusivos diseños!"));

        return product;
    }

    @GetMapping(path = { "/products" })
    public String saludar(Model model) {
        model.addAttribute("products", getProducts());
        return "index";
    }

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
