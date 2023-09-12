package com.example.PracticoPersistenciTUP.repositorios;

import com.example.PracticoPersistenciTUP.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepositorio extends JpaRepository<Domicilio,Long> {
}
