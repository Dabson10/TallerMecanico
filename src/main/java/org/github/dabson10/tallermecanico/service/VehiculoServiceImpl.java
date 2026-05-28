package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCompletoDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCreateDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoUpdateDTO;
import org.github.dabson10.tallermecanico.entity.Vehiculo;

import java.util.List;

public interface VehiculoServiceImpl{

    VehiculoCompletoDTO crearVehiculo(VehiculoCreateDTO vehiculo);
    //Lista los vehículos y la información de los clientes
    List<VehiculoCompletoDTO> traerVehiculos();
    VehiculoCompletoDTO traerVehiculo(String placa);

    VehiculoSimpleDTO actualizarVehiculo(VehiculoUpdateDTO vehiculoDTO);

    Vehiculo existenciaVehiculo(String placas);
}
