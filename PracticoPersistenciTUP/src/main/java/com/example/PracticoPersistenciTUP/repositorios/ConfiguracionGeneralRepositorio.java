package com.example.PracticoPersistenciTUP.repositorios;

import com.example.PracticoPersistenciTUP.entidades.ConfiguracionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionGeneralRepositorio extends JpaRepository<ConfiguracionGeneral,Long> {
}
