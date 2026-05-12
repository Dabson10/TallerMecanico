package org.github.dabson10.tallermecanico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoRefaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id_refaccion;
    @NotBlank(message = "Ingrese un nombre.")
    private String nombre;
    @NotBlank(message = "Ingrese un numero.")
    private String numero;
    @NotNull(message = "Ingrese una cantidad.")
    @Positive(message = "Las cantidades deben de ser positivo.")
    private Integer stock;
    @NotNull(message = "Ingrese un precio.")
    @Positive(message = "El precio debe de ser positivo.")
    private Float precioActual;
}
