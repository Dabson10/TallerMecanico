package org.github.dabson10.tallermecanico.dto.detalleOrdenDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;

@Getter @Setter
@NoArgsConstructor
public class DetalleSimpleDTO {
    private Long id_detalle_orden;
    private Integer cantidad;
    private Float precio_unitario;
    private CatalogoRefaccion refaccion;
}
