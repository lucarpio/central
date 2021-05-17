package edu.programacion.central.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.programacion.central.domain.Producto;
import edu.programacion.central.repository.ProductoRepository;


@Service
public class ProductoServiceImp implements ProductoService{
    
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarTodos(){
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public void guardar(Producto producto) {
        productoRepository.save(producto);
        
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
        
    }
}
