package cu.codigo200.ms.model;

/**
 * Created by yoandypv on 20/11/17.
 */
public class Producto {

    private String nombre;
    private Integer cantidadDisponible;

    public Producto() {
    }

    public Producto(String nombre, Integer cantidadDisponible) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public boolean disminuirCantidadDisponible(Integer cantDisminuir){
        if (this.cantidadDisponible >= cantDisminuir) {
            this.cantidadDisponible -= cantDisminuir;
            return true;
        }
        return false;
    }
}
