

public class ListaProductos
{

    private Nodo cabeza;


    public ListaProductos()
    {
        this.cabeza = null;
    }


    public boolean estaVacia()
    {
        return cabeza == null;
    }


    public void insertarProductoAlInicio(Producto nuevoProducto)
    {

        Nodo nuevoNodo = new Nodo(nuevoProducto);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }

    public void insertarProductoAlFinal(Producto nuevoProducto)
    {

        Nodo nuevoNodo = new Nodo(nuevoProducto);

        if (estaVacia())
        {
            cabeza = nuevoNodo;
        }
        else
        {
            Nodo actual = cabeza;

            while (actual.getSiguiente() != null)
            {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevoNodo);
        }
    }


    public String listarProductos()
    {

        if (estaVacia())
        {
            return "La lista está vacía";
        }

        String resultado = "";
        Nodo actual = cabeza;

        while (actual != null)
        {
            resultado += actual.getProducto().toString() + "\n----------------------------------\n";
            actual = actual.getSiguiente();
        }

        return resultado;
    }

    public boolean modificarProducto(String nombreBuscado, Producto nuevoProducto)
    {
        Nodo actual = cabeza;

        while (actual != null)
        {
            if (actual.getProducto().getNombre().equalsIgnoreCase(nombreBuscado))
            {
                actual.getProducto().setNombre(nuevoProducto.getNombre());
                actual.getProducto().setPrecio(nuevoProducto.getPrecio());
                actual.getProducto().setCategoria(nuevoProducto.getCategoria());
                actual.getProducto().setFechaVencimiento(nuevoProducto.getFechaVencimiento());
                actual.getProducto().setCantidad(nuevoProducto.getCantidad());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean eliminarProducto(String nombre)
    {
        if (estaVacia()) return false;

        if (cabeza.getProducto().getNombre().equalsIgnoreCase(nombre))
        {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Nodo actual = cabeza;

        while (actual.getSiguiente() != null)
        {
            if (actual.getSiguiente().getProducto().getNombre().equalsIgnoreCase(nombre))
            {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public String reporteCostos()
    {
        if (estaVacia()) return "No hay productos";

        Nodo actual = cabeza;
        double totalGeneral = 0;
        String reporte = "REPORTE DE COSTOS\n\n";

        while (actual != null)
        {
            Producto p = actual.getProducto();
            double subtotal = p.getPrecio() * p.getCantidad();

            reporte += p.getNombre() + " -> ₡" + subtotal + "\n";

            totalGeneral += subtotal;
            actual = actual.getSiguiente();
        }

        reporte += "\nTOTAL GENERAL: ₡" + totalGeneral;
        return reporte;
    }

    public Producto buscarProducto(String nombre)
    {
        Nodo actual = cabeza;

        while (actual != null)
        {
            if (actual.getProducto().getNombre().equalsIgnoreCase(nombre))
                return actual.getProducto();

            actual = actual.getSiguiente();
        }

        return null;
    }

    public Nodo getCabeza()
    {
        return cabeza;
    }
}