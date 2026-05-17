package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCompletoDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCreateDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehiculoMapper {
    /**
     * Las siguientes dos clases sirven para formatear ya sea de: <br>
     * -------- VehiculoSimpleDTO a Vehiculo /// {@link #paraVehiculoSimple(VehiculoSimpleDTO)}-------- <br>
     * -------- Vehiculo a VehiculoSimpleDTO /// {@link #paraVehiculoSimpleDTO(Vehiculo)}--------
     */
    Vehiculo paraVehiculoSimple(VehiculoSimpleDTO vehiculoDTO);
    VehiculoSimpleDTO paraVehiculoSimpleDTO(Vehiculo vehiculo);

    /**
     * Las siguientes funciones son para convertir de: <br>
     */
    Vehiculo paraVehiculoCompleto(VehiculoCompletoDTO vehiculo);
    VehiculoCompletoDTO paraVehiculoCompletoDTO(Vehiculo vehiculo);
    /**
     * Las siguientes funciones son para formatear de: <br>
     */
    VehiculoCompletoDTO paraDTOCompleto(VehiculoCreateDTO vehiculo);

}
