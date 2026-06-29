package org.github.dabson10.tallermecanico.dto.tecnicoDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoSNTecnicoDTO;


import java.util.List;

@NoArgsConstructor
@Getter @Setter
@ToString
public class TecnicoCompletoDTO {
    private Long id_tecnico;
    private String nombre;
    private String correo;
    private Boolean activo;
    private List<OrdenServicioCompletoSNTecnicoDTO> ordenes;
}
