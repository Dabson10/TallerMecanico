package org.github.dabson10.tallermecanico.dto.ordenServicioDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrdenServicioRequerimientoDTO {
    private Long id_orden;
    @NotBlank(message = "Ingrese el problema del vehiculo")
    private String problema;
    @NotBlank(message = "Ingrese el correo del cliente.")
    private String correoCliente;
    @NotBlank(message = "Ingrese el correo del técnico")
    private String correoTecnico;
}
