package org.github.dabson10.tallermecanico.utility.vehiculoFormat;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class VehiculoSimpleFormat {
    public Vehiculo vehiculoFormatData(VehiculoSimpleDTO vehiculoDTO){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId_vehiculo(vehiculoDTO.getId_vehiculo());
        vehiculo.setMarca(vehiculoDTO.getMarca());
        vehiculo.setModelo(vehiculoDTO.getModelo());
        vehiculo.setYear(vehiculoDTO.getYear());
        vehiculo.setPlacas(vehiculoDTO.getPlacas());
        vehiculo.setColor(vehiculoDTO.getColor());
        return vehiculo;
    }


    public VehiculoSimpleDTO vehiculoFormatData(Vehiculo vehiculoDTO){
        VehiculoSimpleDTO vehiculo = new VehiculoSimpleDTO();
        vehiculo.setId_vehiculo(vehiculoDTO.getId_vehiculo());
        vehiculo.setMarca(vehiculoDTO.getMarca());
        vehiculo.setModelo(vehiculoDTO.getModelo());
        vehiculo.setYear(vehiculoDTO.getYear());
        vehiculo.setPlacas(vehiculoDTO.getPlacas());
        vehiculo.setColor(vehiculoDTO.getColor());
        return vehiculo;
    }
}
