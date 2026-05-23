package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetallesCompletoDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DetallesMapper {

    @Autowired
    @Lazy
    private OrdenServicioMapper ordenMapper;

    DetalleSimpleDTO paraDetalleSimpleDTO(DetalleOrden detalle) {
        return null;
    }

    public abstract List<DetalleSimpleDTO> paraDetallesSimplesDTO(List<DetalleOrden> detalles);

    public abstract DetallesCompletoDTO paraDetallesCompletoDTO(DetalleOrden orden);
}
