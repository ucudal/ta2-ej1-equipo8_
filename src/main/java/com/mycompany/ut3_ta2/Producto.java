/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut3_ta2;

/**
 *
 * @author juan-
 */
public class Producto implements IProducto {
    
    private String nombre;
    private String codigo;
    private int precio;
    private int stock;
    
    public Producto(String nombre, String codigo, int precio, int stock){
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        
    }

       

    @Override
    public void agregarCantidadStock(Integer stock) {
        this.stock += stock;
    }

    @Override
    public void restarCantidadStock(Integer stock) {
        if (this.stock <= stock){
            this.stock = 0;
        }
        else {
            this.stock -= stock;
        }
    }

    @Override
    public Comparable getCodProducto() {
        return this.codigo;
    }

    @Override
    public Integer getPrecio() {
        return this.precio;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
