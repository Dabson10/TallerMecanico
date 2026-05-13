package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehiculoMapper {
    /**
     * Las siguientes dos clases sirven para formatear ya sea de: <br>
     * -------- VehiculoSimpleDTO a Vehiculo /// {@link #paraVehiculo(VehiculoSimpleDTO)}-------- <br>
     * -------- Vehiculo a VehiculoSimpleDTO /// {@link #paraVehiculoSimpleDTO(Vehiculo)}--------
     */
    Vehiculo paraVehiculo(VehiculoSimpleDTO vehiculoDTO);
    VehiculoSimpleDTO paraVehiculoSimpleDTO(Vehiculo vehiculo);

    /**
     * Las siguientes funciones son para convertir de: <br>
     */
}
