package cu.codigo200.ms.web;

import cu.codigo200.ms.controller.ListaPoductos;
import cu.codigo200.ms.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yoandypv on 24/11/17.
 */


@RestController
@RefreshScope
public class ProductoAPI {

    @Autowired
    private ListaPoductos listaPoductos;

    @Value("${multiplicador:3}")
    private Integer multiplicador;

    @RequestMapping(value = "/mostrarMultiplicador", method = RequestMethod.GET)
    public ResponseEntity<Integer> mostrarMultiplicador(){

        return new ResponseEntity<Integer>(this.multiplicador, HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/agregarProducto", method = RequestMethod.POST)
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto){

        listaPoductos.adicionarProducto(producto);
        // Esto no va a dar errores, es muy simple
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/descontarCantidad", method = RequestMethod.GET)
    public ResponseEntity<String> descontarCantidad(String nombre, Integer cantidadExtraer){

       Integer resultado = listaPoductos.extraerProducto(nombre, cantidadExtraer);

       switch (resultado) {
           case -1:
               return new ResponseEntity("No se encontró el producto", HttpStatus.NO_CONTENT);
           case 0:
               return new ResponseEntity("No fue posible disminuir la cantidad solicitada",HttpStatus.NOT_ACCEPTABLE);
           default:
               return new ResponseEntity("Acción ejecutada correctamente", HttpStatus.OK);
       }
    }




}
