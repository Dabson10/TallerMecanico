package org.github.dabson10.tallermecanico.dto.detalleOrdenDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioSimpleDTO;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;

@Getter @Setter
@NoArgsConstructor
public class DetallesCompletoDTO {
    private Long id_detalle_orden;
    private Integer cantidad;
    private Float precio_unitario;
    private OrdenServicioSimpleDTO ordenServicio;
    private CatalogoRefaccion refaccion;
}
