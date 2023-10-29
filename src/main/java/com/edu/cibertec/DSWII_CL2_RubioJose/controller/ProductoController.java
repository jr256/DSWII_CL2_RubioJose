package com.edu.cibertec.DSWII_CL2_RubioJose.controller;

import com.edu.cibertec.DSWII_CL2_RubioJose.exception.ResourceNotFoundException;
import com.edu.cibertec.DSWII_CL2_RubioJose.model.bd.Producto;
import com.edu.cibertec.DSWII_CL2_RubioJose.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productoList = new ArrayList<>();
        productoService.listarProductos()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(
            @PathVariable("id") Integer id){
        Producto producto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }


     @GetMapping("/productoname/{productoname}")
    public ResponseEntity<Producto> obtenerProductoPorNombre(
            @PathVariable("productoname") String productoName){
        Producto producto = productoService
                .obtenerProductoPorNombre(productoName)
                .orElseThrow(() -> new ResourceNotFoundException("El productocon el nombre "+
                        productoName + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/vencimiento2024")
    public List<Producto>  obtenerProductosConVencimientoEn2024() {
        return productoService.obtenerProductosConVencimiento2024();
    }

    @GetMapping("/cantidadentre10100")
    public List<Producto>  obtenerProductosEntre10y100() {
        return productoService.obtenerProductosEntre10y100();
    }


    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(
            @RequestBody Producto producto
    ){
        return new ResponseEntity<>(
                productoService.guardar(producto), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto
    ){
        Producto oldProducto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));
        oldProducto.setNombre(producto.getNombre());
        oldProducto.setDescripcion(producto.getDescripcion());
        oldProducto.setCantidad(producto.getCantidad());
        return new ResponseEntity<>(
                productoService.guardar(oldProducto), HttpStatus.OK
        );
    }




}
