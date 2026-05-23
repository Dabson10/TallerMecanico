package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioHistorialDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioSimpleDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenSinDetallesDTO;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DetallesMapper.class} )
public interface OrdenServicioMapper {
    /**
     * Las siguientes funciones son para convertir de una clase <br>
     * ------- {@code OrdenServicio} a {@code OrdenServicioCompletoDTO} ------- <br>
     * ------- {@code OrdenServicioCompletoDTO} a {@code OrdenServicio} -------
     */
    public OrdenServicio paraOrdenServicio(OrdenServicioCompletoDTO orden);
    @Mapping(source = "fecha_registro", target = "fecha_registro")
    @Mapping(source = "detalles", target = "detalles")
    OrdenServicioCompletoDTO paraOrdenServicioCompletoDTO(OrdenServicio orden);


    OrdenServicioHistorialDTO paraOrdenServicioHistorialDTO(OrdenServicio orden);

    List<OrdenSinDetallesDTO> paraOrdenesSinDetallesDTO(List<OrdenServicio> orden);

    OrdenServicioSimpleDTO paraOrdenSimpleDTO(OrdenServicio orden);
}
