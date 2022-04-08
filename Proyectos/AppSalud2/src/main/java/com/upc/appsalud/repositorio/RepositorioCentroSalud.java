package com.upc.appsalud.repositorio;

import com.upc.appsalud.entidades.CentroSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioCentroSalud extends JpaRepository<CentroSalud,Long> {
    @Query("SELECT c FROM CentroSalud c WHERE c.tipo=:xTipo")
    public List<CentroSalud> obtenerReporte(@Param("xTipo") String xTipo);
}
