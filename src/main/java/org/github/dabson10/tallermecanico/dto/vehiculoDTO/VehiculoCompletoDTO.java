package org.github.dabson10.tallermecanico.dto.vehiculoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoCompletoDTO {
    private Long id_vehiculo;
    private String marca;
    private String modelo;
    private String year;
    private String placas;
    private String color;
    //Atributo de cliente simple.
    private ClienteSimpleDTO cliente;
}
