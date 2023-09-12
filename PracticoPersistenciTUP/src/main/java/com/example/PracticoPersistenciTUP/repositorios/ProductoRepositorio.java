package com.example.PracticoPersistenciTUP.repositorios;

import com.example.PracticoPersistenciTUP.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
}
