package com.example.PracticoPersistenciTUP.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "clientes")
public class Cliente extends BaseEntidad {

    private String nombre;
    private String apellido;
    private String numeroTelefono;
    private String correoElectronico;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente")
    private List<Pedido> pedidos;

}



