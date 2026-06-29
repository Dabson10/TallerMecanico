package org.github.dabson10.tallermecanico.dto.ordenServicioDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteMedioDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.enums.Estados;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrdenServicioCompletoSNTecnicoDTO {
    private Long id_orden;
    private String problema;
    private LocalDate fecha_registro;
    private Estados estado;
    private ClienteMedioDTO cliente;
    private List<DetalleSimpleDTO> detalles;
}
//Arregla el JSON
