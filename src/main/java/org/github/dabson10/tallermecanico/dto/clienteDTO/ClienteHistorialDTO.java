package org.github.dabson10.tallermecanico.dto.clienteDTO;

import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioHistorialDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;

import java.util.List;

@Getter @Setter
public class ClienteHistorialDTO {
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private VehiculoSimpleDTO vehiculo;
    private List<OrdenServicioHistorialDTO> ordenes;
}
