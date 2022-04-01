package com.upc.appsalud.negocio;

import com.upc.appsalud.entidades.CentroSalud;
import com.upc.appsalud.repositorio.RepositorioCentroSalud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegocioCentroSalud {
    @Autowired
    private RepositorioCentroSalud repositorioCentroSalud;

    public CentroSalud registrar(CentroSalud centroSalud){
        return repositorioCentroSalud.save(centroSalud);
    }
    public double calcularCalificacion(CentroSalud centroSalud){
        return centroSalud.getCalificacionInfraestructura()*0.35 +
                centroSalud.getCalificacionServicios()*0.65;
    }

    public String obtenerResultadoFinal(CentroSalud centroSalud){
        double calificacion = calcularCalificacion(centroSalud);
        if(calificacion>80)
            return "Aprobado";
        else
            return "desaprobado";
    }
    
}
