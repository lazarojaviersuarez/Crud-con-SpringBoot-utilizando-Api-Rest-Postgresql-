package com.lazarojavier.Crud.Service;

import com.lazarojavier.Crud.Entity.Product;
import com.lazarojavier.Crud.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    HashMap<String, Object> datos;

    @Autowired
    private final Repo repository;

    public ProductService(Repo repository) {
        this.repository = repository;
    }


    public List<Product> GetProducto(){
        return this.repository.findAll();
    }


    public ResponseEntity<Object> newProducto(Product producto) {
        Optional<Product> res =  repository.findProductoById(producto.getId());
        datos = new HashMap<>();
        if (res.isPresent() ){
            datos.put("error", true);
            datos.put("message","El producto ya existe");
            return new ResponseEntity<>(datos,
                    HttpStatus.CONFLICT);
        };
        repository.save(producto);
        datos.put("data",producto);
        datos.put("message","Se guardo con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED

        );
    }
    public ResponseEntity<Object> ActualizarProducto(Product producto){
        datos = new HashMap<>();
        Optional<Product> id =  repository.findProductoById(producto.getId());
        if(id.isPresent()) {
            repository.save(producto);
            datos.put("message", " Se actualizo con exito");
            datos.put("data", producto);

            return new ResponseEntity<>(
                    datos,
                    HttpStatus.ACCEPTED
            );
        }
        datos.put("Error",true);
        datos.put("message","No existe un producto con ese id");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CONFLICT
        );

    }
    public ResponseEntity<Object> EliminarProducto(long id){
        datos = new HashMap<>();
        boolean existe = this.repository.existsById(id);
        if(!existe){
            datos.put("Error",true);
            datos.put("message","No existe un producto con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );

        }
        repository.deleteById(id);
        datos.put("message"," producto Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED);
    }


}

