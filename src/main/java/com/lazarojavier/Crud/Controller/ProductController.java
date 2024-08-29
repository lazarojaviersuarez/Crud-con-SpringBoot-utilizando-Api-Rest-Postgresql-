package com.lazarojavier.Crud.Controller;

import com.lazarojavier.Crud.Entity.Product;
import com.lazarojavier.Crud.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api-v1")
public class ProductController {
    @Autowired
    private final ProductService productoService;



    public ProductController ( ProductService productoService){
        this.productoService = productoService;


    }
    @GetMapping
    public List<Product> getProducto(){
        return this.productoService.GetProducto();
    }


    @PostMapping( "/products")
    public ResponseEntity<Object> registrarProducto(@RequestBody Product producto){
        return this.productoService.newProducto(producto);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Object> actualizarProducto(@RequestBody Product producto){
        return this.productoService.ActualizarProducto(producto);
    }
    @DeleteMapping(path = "{Productoid}")
    public ResponseEntity<Object> Eliminar(@PathVariable("Productoid") long id){
        return this.productoService.EliminarProducto(id);
    }
}


