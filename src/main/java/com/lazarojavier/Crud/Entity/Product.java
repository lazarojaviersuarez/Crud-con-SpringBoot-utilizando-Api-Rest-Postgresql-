package com.lazarojavier.Crud.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "antiguedad")
    private int antiguedad;
    @Column(name= "precio")
    private float precio;
    @Column(name= "codigo")
    private String codigo;



}
