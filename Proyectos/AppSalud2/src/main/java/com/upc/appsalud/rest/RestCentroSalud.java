package com.upc.appsalud.rest;

import com.upc.appsalud.entidades.CentroSalud;
import com.upc.appsalud.negocio.NegocioCentroSalud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestCentroSalud {
    @Autowired
    private NegocioCentroSalud negocioCentroSalud;

    @PostMapping("/centro")
    public CentroSalud crearCentro(@RequestBody CentroSalud centroSalud){
        CentroSalud c=null;
        try {
            c = negocioCentroSalud.registrar(centroSalud);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puedo registrar");
        }
        return c;
    }

    @GetMapping("/centros/{tipo}")
    public List<CentroSalud> obtenerCentrosTipo(@PathVariable(value = "tipo") String tipo){
        return negocioCentroSalud.obtenerReporte(tipo);
    }
    @GetMapping("/calificacion/{codigo}")
    public double calcularCalificacion(@PathVariable(value = "codigo") Long codigo){
        return negocioCentroSalud.obtenerCalificacion(codigo);
    }
}
