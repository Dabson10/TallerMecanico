package org.github.dabson10.tallermecanico.dto.detalleOrdenDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DetalleNuevoDTO {
    @NotNull(message = "Ingrese el id de la orden.")
    @Positive(message = "Ingrese un id valido.")
    private Long id_orden;
    @NotNull(message = "Ingrese una cantidad.")
    @Positive(message = "Ingrese una cantidad positiva.")
    private Integer cantidad;
    @NotBlank(message = "Ingrese un numero de refacción.")
    private String numero;
}
