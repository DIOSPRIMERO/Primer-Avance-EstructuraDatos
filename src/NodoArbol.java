public class NodoArbol {

    Producto dato;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(Producto dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}