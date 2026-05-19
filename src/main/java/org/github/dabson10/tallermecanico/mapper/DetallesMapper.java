package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetallesMapper {

    DetalleSimpleDTO paraDetalleSimpleDTO(DetalleOrden detalle);

    List<DetalleSimpleDTO> paraDetallesSimplesDTO(List<DetalleOrden> detalles);

}
