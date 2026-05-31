package org.github.dabson10.tallermecanico.dto.ordenServicioDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteMedioDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.enums.Estados;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class OrdenSinDetallesDTO {
    private Long id_orden;
    private String problema;
    private LocalDate fecha_registro;
    private Estados estado;
    private ClienteMedioDTO cliente;
    private TecnicoSimpleDTO tecnico;
}
