package edu.programacion.central.service;

import java.util.List;

import edu.programacion.central.domain.Producto;

public interface ProductoService {
    public List<Producto> listarTodos();
    public void guardar(Producto producto);
    public Producto buscarPorId(Long id);
    public void eliminar(Long id);    
}
