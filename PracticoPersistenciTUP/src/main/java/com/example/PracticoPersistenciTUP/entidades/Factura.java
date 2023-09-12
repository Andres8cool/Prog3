package com.example.PracticoPersistenciTUP.entidades;

import com.example.PracticoPersistenciTUP.Enumeration.FormadePago;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends BaseEntidad{

    private String fecha;
    private int numero;
    private double descuento;
    private FormadePago formadePago;
    private double total;


}
