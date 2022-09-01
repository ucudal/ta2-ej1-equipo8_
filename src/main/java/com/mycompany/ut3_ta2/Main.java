package com.mycompany.ut3_ta2;

import static java.lang.Integer.parseInt;

/**
 *
 * @author abadie
 */
public class Main {
    
    public static void main(String[] args){
        // TODO: 
        /**
         * Instanciar almacen
         * Agregar: productos y cantidades (altas.txt)
         * Emitir listado de productos y cantidades
         * Emitir valor de stock de todo el almacen
         * Vender: restar stock de productos indicado en ventas.txt
         * Emitir valor de stock de todo el almacen
         **/
        
        String[] compra = ManejadorArchivosGenerico.leerArchivo("src/altas.txt");
        String[] venta = ManejadorArchivosGenerico.leerArchivo("src/ventas.txt");
        
        Lista<Producto> lista = new Lista<>();
        Almacen almacen = new Almacen();
        
        System.out.println("El monto total en que se ha incrementado el stock es: " + almacen.altas(compra));
        
        System.out.println("Los productos disponibles son:");
        almacen.imprimirProductos();
        
        System.out.println("El valor total del stock es: " + almacen.obtenerValorStock());
        
        System.out.println("El monto total en que se ha decrementado el stock es: " + almacen.venta(venta));
        
        System.out.println("El valor total del stock luego de la venta es: " + almacen.obtenerValorStock());
    }
    
    
}
