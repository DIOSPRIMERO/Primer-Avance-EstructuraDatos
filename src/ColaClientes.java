import java.util.LinkedList;

public class ColaClientes {

    private LinkedList<Cliente> cola;

    public ColaClientes() {
        cola = new LinkedList<>();
    }

    // ENCOLAR
    public void encolar(Cliente c) {

        if (cola.isEmpty()) {
            cola.add(c);
            return;
        }

        int i = 0;

        // Insertar según prioridad (mayor primero)
        while (i < cola.size() &&
                cola.get(i).getPrioridad() >= c.getPrioridad()) {
            i++;
        }

        cola.add(i, c);
    }

    //  ATENDER
    public Cliente atenderSiguiente() {

        if (estaVacia()) return null;

        return cola.removeFirst();
    }

    //ESTA VACIA
    public boolean estaVacia() {
        return cola.isEmpty();
    }
}