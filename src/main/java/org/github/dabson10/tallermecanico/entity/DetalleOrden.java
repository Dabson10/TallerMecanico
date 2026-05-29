package org.github.dabson10.tallermecanico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id_detalle_orden;
    @NotNull(message = "Ingrese una cantidad valida.")
    private Integer cantidad;
    @Positive(message = "Ingrese un precio positivo.")
    @NotNull(message = "Ingrese un precio unitario.")
    private Float precio_unitario;
    @ManyToOne
    @JoinColumn(name = "detalles_id")
    private OrdenServicio ordenServicio;
    @ManyToOne
    @JoinColumn(name = "refaccion_id")
    private CatalogoRefaccion refaccion;
}
