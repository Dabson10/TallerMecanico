package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Vehiculo;

public interface VehiculoServiceImpl{

    VehiculoSimpleDTO crearVehiculo(VehiculoSimpleDTO vehiculo);

    Vehiculo existenciaVehiculo(String placas);
}
