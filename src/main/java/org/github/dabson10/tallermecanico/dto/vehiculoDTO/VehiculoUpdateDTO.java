package org.github.dabson10.tallermecanico.dto.vehiculoDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehiculoUpdateDTO {
    @NotBlank(message = "Ingrese las placas nuevas.")
    private String placasNuevas;
    @NotBlank(message = "Ingrese el color nuevo.")
    private String colorNuevo;
    @NotBlank(message = "Ingrese las placas del vehiculo.")
    private String placas;
}
