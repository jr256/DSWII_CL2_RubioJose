package com.edu.cibertec.DSWII_CL2_RubioJose.service;

import com.edu.cibertec.DSWII_CL2_RubioJose.model.bd.Producto;
import com.edu.cibertec.DSWII_CL2_RubioJose.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {


    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }

    public Optional<Producto> obtenerProductoPorNombre(String productoName){
        Optional<Producto> producto = productoRepository.findByProductoname(productoName);
        if(producto.isEmpty())
            return  Optional.empty();
        else
            return producto;
    }

    public List<Producto> obtenerProductosEntre10y100() {
        return productoRepository.filtrarProductosEntre10y100();
    }

    public List<Producto> obtenerProductosConVencimiento2024() {
        return productoRepository.filtrarVencimiento2024();
    }




    
    
}
