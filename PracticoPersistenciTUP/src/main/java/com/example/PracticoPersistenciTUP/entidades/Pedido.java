package com.example.PracticoPersistenciTUP.entidades;

import com.example.PracticoPersistenciTUP.Enumeration.Estado;
import com.example.PracticoPersistenciTUP.Enumeration.TipodeEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends BaseEntidad {
    private String fecha;
    private Estado estado;
    private String horaEstimadaEntrega;
    private TipodeEnvio tipodeEnvio;
    private double total;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallesPedido = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Factura factura;

}
