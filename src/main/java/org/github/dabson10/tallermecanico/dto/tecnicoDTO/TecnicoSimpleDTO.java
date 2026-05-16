package org.github.dabson10.tallermecanico.dto.tecnicoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoSimpleDTO {
    private Long id_tecnico;
    private String nombre;
    private String correo;
    private Boolean activo;
}
