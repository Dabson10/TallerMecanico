package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCompletoDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCreateDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Vehiculo;

public interface VehiculoServiceImpl{

    VehiculoCompletoDTO crearVehiculo(VehiculoCreateDTO vehiculo);

    Vehiculo existenciaVehiculo(String placas);
}
