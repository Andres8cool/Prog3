package com.example.PracticoPersistenciTUP.repositorios;

import com.example.PracticoPersistenciTUP.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Long> {
}
