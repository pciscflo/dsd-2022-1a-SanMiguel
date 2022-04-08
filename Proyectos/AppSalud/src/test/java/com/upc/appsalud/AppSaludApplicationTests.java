package com.upc.appsalud;

import com.upc.appsalud.entidades.CentroSalud;
import com.upc.appsalud.negocio.NegocioCentroSalud;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppSaludApplicationTests {
    @Autowired
    private NegocioCentroSalud negocioCentroSalud;

    @Test
    void contextLoads() {
    }

    @Test
    public void probarRegistrar(){
        CentroSalud centroSalud = new CentroSalud();
        centroSalud.setCalificacionServicios(95);
        centroSalud.setCalificacionInfraestructura(90);
        centroSalud.setNombre("Almenara");
        centroSalud.setTipo("Hospital");
        centroSalud.setAmbulancias(true);
        negocioCentroSalud.registrar(centroSalud);

    }
    @Test
    public void probarResultadoFinal(){
        CentroSalud centroSalud = new CentroSalud();
        centroSalud.setCodigo(2L);
        String resultado;
        resultado = negocioCentroSalud.obtenerResultadoFinal(centroSalud.getCodigo());
        Assert.assertEquals("Aprobado",resultado);
    }
    @Test
    public void probarReporte(){
        List<CentroSalud> centros;
        centros = negocioCentroSalud.obtenerReporte("Clinica");
        for(CentroSalud c:centros){
            System.out.println(c.toString());
        }
        Assert.assertNotNull(centros);
    }

}
