package org.github.dabson10.tallermecanico.dto.ordenServicioDTO;

import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.enums.Estados;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
//@NoArgsConstructor
public class OrdenServicioHistorialDTO {
    private Long id_orden;
    private String problema;
    private LocalDate fecha_registro;
    private Estados estado;
    private List<DetalleSimpleDTO> detalles;
}
