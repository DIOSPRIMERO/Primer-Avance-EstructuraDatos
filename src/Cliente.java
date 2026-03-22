public class Cliente {

    private String nombre;
    private int prioridad; // 1, 2, 3

    public Cliente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getNombre() {
        return nombre;
    }

}