package org.github.dabson10.tallermecanico.dto.vehiculoDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class VehiculoCreateDTO {
    private Long id_vehiculo;
    @NotBlank(message = "Ingrese la marca del vehículo.")
    private String marca;
    @NotBlank(message = "Ingrese el modelo del vehículo")
    private String modelo;
    @NotBlank(message = "Ingrese el año del vehículo.")
    private String year;
    @NotBlank(message = "Ingrese las placas del vehículo.")
    private String placas;
    @NotBlank(message = "Ingrese el color del vehículo.")
    private String color;
    @NotBlank(message = "Ingrese el correo del cliente.")
    private String correoCliente;
}
