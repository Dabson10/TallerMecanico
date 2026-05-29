package org.github.dabson10.tallermecanico.dto.detalleOrdenDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class DetalleCantidadDTO {
    @NotNull(message = "Ingrese un ID de detalle.")
    private Long id_detalle_orden;
    @NotNull(message = "Ingrese una cantidad")
    @Min(value = 1, message = "Ingrese una cantidad valida.")
    private Integer cantidad;
}
