package com.lazarojavier.Crud.Repository;

import com.lazarojavier.Crud.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@org.springframework.stereotype.Repository
public interface Repo extends JpaRepository<Product,Long> {
       Optional<Product> findProductoByCodigo(String codigo);
        Optional<Product> findProductoByNombre(String nombre);
        Optional<Product> findProductoById(long id);
    }


