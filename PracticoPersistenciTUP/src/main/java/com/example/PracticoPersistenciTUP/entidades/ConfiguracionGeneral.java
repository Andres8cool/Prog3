package com.example.PracticoPersistenciTUP.entidades;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfiguracionGeneral extends BaseEntidad{

    private int cantidadCocineros;

    private String emailEmpresa;

    private String tokenMercadoPago;
}