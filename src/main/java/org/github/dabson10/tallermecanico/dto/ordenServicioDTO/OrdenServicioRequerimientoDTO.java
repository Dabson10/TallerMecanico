package org.github.dabson10.tallermecanico.dto.ordenServicioDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrdenServicioRequerimientoDTO {
    private Long id_orden;
    private String problema;
    private String correoCliente;
    private String correoTecnico;
}
