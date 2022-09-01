/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut3_ta2;

import static java.lang.Integer.parseInt;

/**
 *
 * @author juan-
 */
public class Almacen implements IAlmacen {

    private Lista<Producto> productos = new Lista<Producto>();

    private String direccion;

    private String telefono;

    private String nombre;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Lista<Producto> getListaProductos() {
        return this.productos;
    }

    @Override
    public long obtenerValorStock() {
        Nodo<Producto> aux = productos.getPrimero();
        long res = 0;
        while (aux != null) {
            res += aux.getDato().getStock() * aux.getDato().getPrecio();
            aux = aux.getSiguiente();
        }
        return res;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo<Producto> nodo = new Nodo<>(unProducto.getCodProducto(), unProducto);
        productos.insertar(nodo);
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        return productos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        String aux = "";
        if (!productos.esVacia()) {
            Nodo<Producto> nodoActual = productos.getPrimero();
            while (nodoActual != null) {
                System.out.println(nodoActual.getDato().getNombre().toString());
                nodoActual = nodoActual.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimirSeparador(String separador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        IProducto producto = buscarPorCodigo(clave);
        producto.agregarCantidadStock(cantidad);
        return true;

    }

    @Override
    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        Producto aux = buscarPorCodigo(codProducto);
        if (aux != null) {
            aux.restarCantidadStock(cantidad);
        }
        return aux.getStock();
    }

    @Override
    public Producto buscarPorCodigo(Comparable codProducto) {
        Nodo<Producto> nodoProducto = productos.buscar(codProducto);
        if (nodoProducto != null) {
            Producto res = nodoProducto.getDato();
            return res;
        }
        return null;
    }

    @Override
    public void listarOrdenadoPorNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadProductos() {
        return productos.cantElementos();
    }

    public int venta(String[] venta) {
        String[] pos = new String[2];
        String codProducto;
        int cantAVender;
        int res = 0;
        for (int i = 0; i < venta.length; i++) {
            pos = venta[i].split(",");
            codProducto = pos[0];
            cantAVender = parseInt(pos[1]);
            this.restarStock(codProducto, cantAVender);
            Producto prod = this.buscarPorCodigo(codProducto);
            res += prod.getPrecio() * cantAVender;
        }
        return res;
    }

    public int altas(String[] altas) {
        int montoTotal = 0;
        int i = 0;
        while (i < altas.length) {
            String[] partes = altas[i].split(",");
            IProducto producto = this.buscarPorCodigo(partes[0]);
            if (producto == null) {
                Producto xProducto = new Producto(partes[1],partes[0],Integer.valueOf(partes[2]),Integer.valueOf(partes[3]));
                this.insertarProducto(xProducto);
            } else {
                this.agregarStock(partes[0], Integer.valueOf(partes[2]));
            }
            montoTotal += Integer.valueOf(partes[2]) * Integer.valueOf(partes[3]);
            i++;
        }

        return montoTotal;
    }

}
