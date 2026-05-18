package org.github.dabson10.tallermecanico.dto.detalleOrdenDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;

public class DetalleRefaccionDTO {
    private Long id_detalle_orden;
    @NotNull(message = "Ingrese una cantidad.")
    @Positive(message = "Ingrese una cantidad positiva.")
    private Integer cantidad;
    @NotNull(message = "Ingrese un precio unitario.")
    @Positive(message = "Ingrese un precio positivo.")
    private Float precio_unitario;
    private CatalogoRefaccion refaccion;

}
