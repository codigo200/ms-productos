package cu.codigo200.ms.controller;

import cu.codigo200.ms.model.Producto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoandypv on 20/11/17.
 */

@Component
public class ListaPoductos {

    List<Producto> productos;

    public ListaPoductos() {
        this.productos = new ArrayList<>();
    }

    public Producto adicionarProducto(Producto producto) {
        this.productos.add(producto);
        return producto;
    }

    public Integer extraerProducto (String nombre, Integer cantidadAExtraer){

        Producto pr = productos.stream()
                .filter(producto -> producto.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);

        if (pr == null)
            return  -1; // No se encontró el producto.
        if (pr.disminuirCantidadDisponible(cantidadAExtraer))
            return 1; // Se disminuyó correctamente.
        else
            return 0; // Se encontró, pero no se pudo disminuir la cantidad.
    }




}
