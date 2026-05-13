package org.github.dabson10.tallermecanico.dto.clienteDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;

@Getter
@Setter
@AllArgsConstructor
public class ClienteCompletoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    //Vehículo con solo los atributos simples.
    private VehiculoSimpleDTO vehiculo;
    //Lista de Órdenes simples.
}
