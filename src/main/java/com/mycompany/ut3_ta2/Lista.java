package com.mycompany.ut3_ta2;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }


    // implementar los metodos indicados en la interfaz

    @Override
    public void insertar(Nodo<T> nodo) {
        if (esVacia()){
            this.primero = nodo;
        }else{
            INodo<T> aux = primero;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> xBuscado = null;
        if(!esVacia())
        {
            Nodo<T> aux = this.primero;
            while(aux.getSiguiente() != null)
            {
                if(aux.getEtiqueta().equals(clave)){
                    xBuscado = aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return xBuscado;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (this.esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().equals(clave)) {
                Nodo<T> temp1 = aux;
                Nodo<T> temp = aux.getSiguiente();
                primero = temp;
                return true;
        }
        while (aux.getSiguiente() != null) {
                if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                    INodo temp = aux.getSiguiente();
                    aux.setSiguiente(temp.getSiguiente());
                    return true;
                }
                aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!this.esVacia()){
            Nodo<T> nodoActual = primero;
            while (nodoActual != null){
                nodoActual.imprimir();
                nodoActual = nodoActual.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } 
        else {
                INodo temp = primero;
                aux = "" + temp.getEtiqueta();
                while (temp.getSiguiente() != null) {
                    aux = aux + separador + temp.getSiguiente().getEtiqueta();
                    temp = temp.getSiguiente();
                }
            }
        return aux;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
            if (esVacia()) {
                    System.out.println("Cantidad de elementos 0.");
                    return 0;
            } 
            else {
                INodo aux = primero;
                while (aux != null) {
                    contador++;
                    aux = aux.getSiguiente();
                }
            }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }
    
    public Nodo<T> getPrimero(){
        return this.primero;
    }
}
