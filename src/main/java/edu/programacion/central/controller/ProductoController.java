package edu.programacion.central.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.programacion.central.model.Producto;
import edu.programacion.central.service.ProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/producto/listar")
    public String listarClientes(Model model){
        List<Producto> listadoProductos = productoService.listarTodos();
        model.addAttribute("titulo", "Lista de produtos");
        model.addAttribute("productos", listadoProductos);
        return "producto/listar";
    }

    @GetMapping("/producto/create")
    public String crear(Model model){

        Producto producto = new Producto();
        model.addAttribute("titulo", "Ingrese Nuevo Producto");
        model.addAttribute("producto", producto);

        return "producto/crear";
    }

    @PostMapping("/producto/save")
    public String guardar(@Valid @ModelAttribute Producto producto, BindingResult result, Model model,
        @RequestParam("file") MultipartFile imagen){
        if(result.hasErrors()){
            model.addAttribute("titulo", "Ingrese Nuevo Producto");
            model.addAttribute("producto", producto);
        }
        if(!imagen.isEmpty()){
            //String ruta = "C://Temp//uploads";
            String rutaAbsoluta = "C://Producto//recursos";
            // Path directorioImagenes = Paths.get("src//main//resources//static//img");
            // String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                producto.setImagen(imagen.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        productoService.guardar(producto);
        System.out.println("Producto registrado con exito");
        return "redirect:/producto/listar";
    }


    @GetMapping("/producto/edit/{id}")
    public String editar(@PathVariable("id") Long idProducto, Model model){

        Producto producto = null;
        if(idProducto > 0){
            producto = productoService.buscarPorId(idProducto);
            if(producto == null){
                return "redirect:/producto/listar";    
            }
        }else{
            return "redirect:/producto/listar";
        }
        
        model.addAttribute("titulo", "Editar Producto");
        model.addAttribute("producto", producto);

        return "producto/crear";
    }


    @GetMapping("/producto/detalle/{id}")
    public String detalleProducto(@PathVariable("id") Long idProducto, Model model){

        Producto producto = null;
        if(idProducto > 0){
            producto = productoService.buscarPorId(idProducto);
            if(producto == null){
                return "redirect:/producto/listar";    
            }
        }else{
            return "redirect:/producto/listar";
        }
        
        model.addAttribute("titulo", "Detalle del producto: "+ producto.getNombre());
        model.addAttribute("producto", producto);

        return "producto/detalleProducto";
    }



    @GetMapping("/producto/delete/{id}")
    public String eliminar(@PathVariable("id") Long idProducto){

        Producto producto = null;
        if(idProducto > 0){
            producto = productoService.buscarPorId(idProducto);
            if(producto == null){
                return "redirect:/producto/listar";    
            }
        }else{
            return "redirect:/producto/listar";
        }

        productoService.eliminar(idProducto);
        System.out.println("Registro eliminado con exito");

        return "redirect:/producto/listar";
    }
}