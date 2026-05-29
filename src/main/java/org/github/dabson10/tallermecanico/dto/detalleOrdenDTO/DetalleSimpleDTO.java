package org.github.dabson10.tallermecanico.dto.detalleOrdenDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;

@Getter @Setter
public class DetalleSimpleDTO {
    private Long id_detalle_orden;
    private Integer cantidad;
    private Float precio_unitario;
    private CatalogoRefaccion refaccion;

    public DetalleSimpleDTO(){}
    @Override
    public String toString() {
        return "DetalleSimpleDTO{" +
                "id_detalle_orden=" + id_detalle_orden +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                ", refaccion=" + refaccion +
                '}';
    }
}
