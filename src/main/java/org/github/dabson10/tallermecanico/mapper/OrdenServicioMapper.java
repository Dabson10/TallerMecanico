package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrdenServicioMapper {
    /**
     * Las siguientes funciones son para convertir de una clase <br>
     * ------- {@code OrdenServicio} a {@code OrdenServicioCompletoDTO} ------- <br>
     * ------- {@code OrdenServicioCompletoDTO} a {@code OrdenServicio} -------
     */
    public OrdenServicio paraOrdenServicio(OrdenServicioCompletoDTO orden);
    @Mapping(source = "fecha_registro", target = "fecha_registro")
    OrdenServicioCompletoDTO paraOrdenServicioCompletoDTO(OrdenServicio orden);
}
