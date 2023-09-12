package com.example.PracticoPersistenciTUP.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rubro extends BaseEntidad{
    private String denominacion;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")
    @Builder.Default
    private List<Producto> productos= new ArrayList<>();

    public void agregarProducto(Producto producto) {

        this.productos.add(producto);
    }

}
