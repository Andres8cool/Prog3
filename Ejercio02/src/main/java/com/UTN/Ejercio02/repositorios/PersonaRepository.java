package com.UTN.Ejercio02.repositorios;

import com.UTN.Ejercio02.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Long> {


}
