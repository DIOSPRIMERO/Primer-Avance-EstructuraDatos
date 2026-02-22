

import java.util.ArrayList;

public class Producto
{

    private String nombre;
    private double precio;
    private String categoria;
    private String fechaVencimiento;
    private int cantidad;
    private ArrayList<String> listaImagenes;


    public Producto(String nombre, double precio, String categoria, String fechaVencimiento, int cantidad)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.listaImagenes = new ArrayList<>();
    }

    public void agregarImagen(String ruta)
    {
        listaImagenes.add(ruta);
    }

    //etters y Setters


    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public String getFechaVencimiento()
    {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento)
    {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    public ArrayList<String> getListaImagenes()
    {
        return listaImagenes;
    }

    @Override
    public String toString()
    {
        String imagenesTexto = "";

        if(listaImagenes.isEmpty())
        {
            imagenesTexto = "Sin imágenes";
        }
        else
        {
            for(String img : listaImagenes)
            {
                imagenesTexto += img + "\n";
            }
        }

        return "Nombre: " + nombre +
                "\nPrecio: ₡" + precio +
                "\nCategoría: " + categoria +
                "\nFecha de Vencimiento: " + fechaVencimiento +
                "\nCantidad: " + cantidad +
                "\nImágenes:\n" + imagenesTexto;
    }
}