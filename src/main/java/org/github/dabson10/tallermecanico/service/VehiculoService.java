package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.github.dabson10.tallermecanico.exceptions.VehiculoDuplicateException;
import org.github.dabson10.tallermecanico.mapper.VehiculoMapper;
import org.github.dabson10.tallermecanico.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService implements VehiculoServiceImpl{
    //Inyección de dependencias.
    private final VehiculoRepository veRe;
    private final VehiculoMapper veMa;
    public VehiculoService(VehiculoRepository veRe, VehiculoMapper veMa){
        this.veRe = veRe;
        this.veMa = veMa;
    }

    /**
     * Esta función sirve para crear un vehículo, mediante la clase simple
     * @param vehiculo : Datos del nuevo vehículo
     * @return : Regresará la clase simple con los datos guardados de la base de datos.
     */
    @Override
    public VehiculoSimpleDTO crearVehiculo(VehiculoSimpleDTO vehiculo) {
        Vehiculo vehi = this.existenciaVehiculo(vehiculo.getPlacas());
        if(vehi != null){
            //Si se encontró algún usuario entonces regresamos
            throw new VehiculoDuplicateException("Placas de vehiculo existente.");
        }
        vehi = veRe.save(veMa.paraVehiculo(vehiculo));
        return veMa.paraVehiculoSimpleDTO(vehi);
    }

    @Override
    public Vehiculo existenciaVehiculo(String placas) {
        return veRe.findByPlacas(placas);
    }
}
