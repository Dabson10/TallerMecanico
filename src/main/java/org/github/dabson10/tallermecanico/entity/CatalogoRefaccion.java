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
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    @Min(value = 0, message = "Ingrese una cantidad valida")
    private Integer stock;
    @NotNull(message = "Ingrese un precio.")
    @Positive(message = "El precio debe de ser positivo.")
    private Float precioActual;

    @PrePersist
    public void newRefaccion(){
        log.info("Se intentara crear una nueva refacción con numero de: {}", numero);
    }

    @PostPersist
    public void refaccionCreada(){
        log.info("Se creo la refacción con numero de: {}", numero);
    }

    public String mostrarDatos(){
        return "Nombre: " + nombre +
                "\nNumero: " + numero +
                "\nStock: " + stock +
                "\nPrecio actual:" + precioActual;
    }
    @PostRemove
    public void antesDeEliminar(){
        log.warn("Estas por eliminar datos.");
    }
}
