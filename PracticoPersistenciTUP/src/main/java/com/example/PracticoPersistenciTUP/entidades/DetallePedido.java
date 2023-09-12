package com.example.PracticoPersistenciTUP.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido extends BaseEntidad{

    private Long id;
    private int cantidad;
    private double subtotal;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
