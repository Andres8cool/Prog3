package com.example.PracticoPersistenciTUP.repositorios;

import com.example.PracticoPersistenciTUP.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura,Long> {
}
