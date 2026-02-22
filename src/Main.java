

import javax.swing.JOptionPane;

public class Main
{

    public static void main(String[] args)
    {
        ListaProductos lista = new ListaProductos();
        menu(lista);
    }

    public static void menu(ListaProductos lista)
    {
        int opcion = 0;

        while (opcion != 7)
        {
            opcion = leerEntero(
                    " SISTEMA DE PRODUCTOS \n" +
                            "1. Agregar producto\n" +
                            "2. Mostrar productos\n" +
                            "3. Modificar producto\n" +
                            "4. Eliminar producto\n" +
                            "5. Reporte de costos\n" +
                            "6. Agregar imagen a producto\n" +
                            "7. Salir");

            if(opcion < 1 || opcion > 7)
            {
                JOptionPane.showMessageDialog(null,"Opción inválida");
                continue;
            }

            if (opcion == 1)
            {
                agregarProducto(lista);
            }
            else if (opcion == 2)
            {
                JOptionPane.showMessageDialog(null, lista.listarProductos());
            }
            else if (opcion == 3)
            {
                modificar(lista);
            }
            else if (opcion == 4)
            {
                eliminar(lista);
            }
            else if (opcion == 5)
            {
                JOptionPane.showMessageDialog(null, lista.reporteCostos());
            }

            else if (opcion == 6) {
                agregarImagen(lista);
            }
        }
    }

    //                       AGREGAR
    public static void agregarProducto(ListaProductos lista)
    {
        String nombre = leerTexto("Nombre:");
        if(nombre == null) return;

        double precio = leerDouble("Precio:");
        if(precio < 0) return;

        String categoria = leerTexto("Categoría:");
        if(categoria == null) return;

        String fecha = leerTexto("Fecha vencimiento:");
        if(fecha == null) return;

        int cantidad = leerEntero("Cantidad:");
        if(cantidad < 0) return;

        Producto p = new Producto(nombre, precio, categoria, fecha, cantidad);

        lista.insertarProductoAlFinal(p);

        JOptionPane.showMessageDialog(null,"Producto agregado correctamente");
    }

    //          MODIFICAR
    public static void modificar(ListaProductos lista)
    {
        String nombre = leerTexto("Producto a modificar:");
        if(nombre == null) return;

        if(lista.buscarProducto(nombre) == null)
        {
            JOptionPane.showMessageDialog(null,"No existe ese producto");
            return;
        }

        String nuevoNombre = leerTexto("Nuevo nombre:");
        if(nuevoNombre == null) return;

        double precio = leerDouble("Nuevo precio:");
        if(precio < 0) return;

        String categoria = leerTexto("Nueva categoría:");
        if(categoria == null) return;

        String fecha = leerTexto("Nueva fecha vencimiento:");
        if(fecha == null) return;

        int cantidad = leerEntero("Nueva cantidad:");
        if(cantidad < 0) return;

        Producto nuevo = new Producto(nuevoNombre, precio, categoria, fecha, cantidad);

        lista.modificarProducto(nombre, nuevo);

        JOptionPane.showMessageDialog(null,"Producto modificado");
    }

    //              ELIMINAR
    public static void eliminar(ListaProductos lista)
    {
        String nombre = leerTexto("Producto a eliminar:");
        if(nombre == null) return;

        int confirmar = JOptionPane.showConfirmDialog(null,
                "¿Seguro que desea eliminar " + nombre + "?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if(confirmar != JOptionPane.YES_OPTION) return;

        if(lista.eliminarProducto(nombre))
            JOptionPane.showMessageDialog(null,"Producto eliminado");
        else
            JOptionPane.showMessageDialog(null,"Producto no encontrado");
    }

    //               VALIDACIONES
    public static String leerTexto(String mensaje)
    {
        String dato;

        do{
            dato = JOptionPane.showInputDialog(mensaje);

            if(dato == null)
            {
                JOptionPane.showMessageDialog(null,"Operación cancelada");
                return null;
            }

            if(dato.trim().isEmpty()) //eliminar espacios en blanco
                                      // devolver true si esta vacia
                JOptionPane.showMessageDialog(null,"No puede quedar vacío");

        } while(dato.trim().isEmpty());
        return dato;
    }

    public static int leerEntero(String mensaje)
    {

        while(true)
        {
            try
            {
                String input = leerTexto(mensaje);
                if(input == null) return -1;

                return Integer.parseInt(input);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Debe ingresar un número entero válido");
            }
        }
    }

    public static double leerDouble(String mensaje)
    {
        while(true)
        {
            try
            {
                String input = leerTexto(mensaje);
                if(input == null) return -1;

                return Double.parseDouble(input);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Debe ingresar un número válido");
            }
        }
    }

    public static void agregarImagen(ListaProductos lista)
    {
        String nombre = JOptionPane.showInputDialog("Digite el nombre del producto:");

        Producto producto = lista.buscarProducto(nombre);

        if(producto == null)
        {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            return;
        }

        String imagen = JOptionPane.showInputDialog(
                "Digite la ruta dentro de la carpeta img\nEjemplo: img/arroz.png");
        producto.agregarImagen(imagen);

        JOptionPane.showMessageDialog(null, "Imagen agregada correctamente");
    }
}