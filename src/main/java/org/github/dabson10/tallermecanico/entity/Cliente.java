package org.github.dabson10.tallermecanico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id_cliente;
    @NotBlank(message = "Ingrese un nombre.")
    private String nombre;
    @NotBlank(message = "Ingrese un apellido.")
    private String apellido;
    @NotBlank(message = "Ingrese un numero de teléfono.")
    private String telefono;
    @Email(message = "Ingrese un correo valido.")
    @NotBlank(message = "Ingrese un correo electrónico.")
    private String correo;
    @OneToOne(mappedBy = "cliente")
    private Vehiculo vehiculo;
    @OneToMany(mappedBy = "cliente")
    private List<OrdenServicio> ordenes;
}
