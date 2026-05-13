package org.github.dabson10.tallermecanico.dto.vehiculoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSimpleDTO {
    private Long id_vehiculo;
    private String marca;
    private String modelo;
    private Integer year;
    private String placas;
    private String color;
}
