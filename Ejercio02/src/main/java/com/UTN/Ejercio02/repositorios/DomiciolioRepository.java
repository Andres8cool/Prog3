package com.UTN.Ejercio02.repositorios;

import com.UTN.Ejercio02.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomiciolioRepository extends JpaRepository<Domicilio,Long> {
}
