public class ArbolProductos {

    private NodoArbol raiz;

    public ArbolProductos() {
        raiz = null;
    }

    //INSERTAR
    public void insertar(Producto p) {
        raiz = insertarRec(raiz, p);
    }

    private NodoArbol insertarRec(NodoArbol actual, Producto p) {

        if (actual == null) {
            return new NodoArbol(p);
        }

        if (p.getNombre().compareToIgnoreCase(actual.dato.getNombre()) < 0) {
            actual.izquierdo = insertarRec(actual.izquierdo, p);
        } else {
            actual.derecho = insertarRec(actual.derecho, p);
            // Si el nombre es igual o mayor, se inserta a la derecha
        }

        return actual;
    }

    // BUSCAR
    public Producto buscar(String nombre) {
        return buscarRec(raiz, nombre);
    }

    private Producto buscarRec(NodoArbol actual, String nombre) {

        if (actual == null) return null;

        if (nombre.equalsIgnoreCase(actual.dato.getNombre())) {
            return actual.dato;
        }

        if (nombre.compareToIgnoreCase(actual.dato.getNombre()) < 0) {
            return buscarRec(actual.izquierdo, nombre);
        } else {
            return buscarRec(actual.derecho, nombre);
        }
    }

    //LISTAR EN ORDEN
    public String listarEnOrden() {
        return listarRec(raiz);
    }


    private String listarRec(NodoArbol actual) {

        if (actual == null) return "";
        return listarRec(actual.izquierdo) +
                actual.dato.toString() + "\n-----------------\n" +
                listarRec(actual.derecho);
    }
}
