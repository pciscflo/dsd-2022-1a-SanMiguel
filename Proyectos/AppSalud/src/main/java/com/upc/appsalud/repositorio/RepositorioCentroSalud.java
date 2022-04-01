package com.upc.appsalud.repositorio;

import com.upc.appsalud.entidades.CentroSalud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCentroSalud extends JpaRepository<CentroSalud,Long> {

}
