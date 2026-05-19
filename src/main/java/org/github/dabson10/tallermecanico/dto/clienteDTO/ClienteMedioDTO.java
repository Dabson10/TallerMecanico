package org.github.dabson10.tallermecanico.dto.clienteDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;

/**
 * Este DTO sirve para solo usar la clase de VehiculoSimple, este DTO
 * lo utilizamos en la parte de OrdenServicioCompleto.
 */
@Getter @Setter
@NoArgsConstructor
public class ClienteMedioDTO {
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private VehiculoSimpleDTO vehiculo;
}
