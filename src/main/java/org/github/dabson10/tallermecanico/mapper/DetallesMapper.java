package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetallesMapper {

    DetalleSimpleDTO paraDetalleSimpleDTO(DetalleOrden detalle);

}
