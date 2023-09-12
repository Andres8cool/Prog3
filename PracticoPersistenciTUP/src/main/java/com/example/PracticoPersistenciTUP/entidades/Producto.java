package com.example.PracticoPersistenciTUP.entidades;

import com.example.PracticoPersistenciTUP.Enumeration.TipodeProducto;
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
public class Producto extends BaseEntidad{


    private TipodeProducto tipodeProducto;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String foto;
    private String receta;


}
