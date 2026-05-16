package org.github.dabson10.tallermecanico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id_vehiculo;
    @NotBlank(message = "Ingrese una marca.")
    private String marca;
    @NotBlank(message = "Ingrese un modelo.")
    private String modelo;
    @NotNull(message = "Ingrese un año correcto.")
    private Integer year;
    @NotBlank(message = "Ingrese las placas.")
    private String placas;
    @NotBlank(message = "Ingrese un color.")
    private String color;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @PrePersist
    public void newVehiculo(){
        log.info("Se intentara crear un nuevo vehiculo a nombre de {}", cliente.getNombre());
    }

    @PostPersist
    public void vehiculoCreado(){
        log.info("Se creo un nuevo vehiculo a nombre: {}", cliente.getNombre());
    }
}
