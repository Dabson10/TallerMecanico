package org.github.dabson10.tallermecanico.utility.actualizarDatos;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoSimpleDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoUpdateDTO;
import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class DatosVehiculoUpdate {

    public Vehiculo datosVehiculoUpdate(VehiculoUpdateDTO vehiculoDTO, Vehiculo vehiculo){
        /*
         *El proceso para guardar datos es simple si el valor es igual al de base de datos y son espacios no guarda nada.
         * Pero si son diferentes y no contiene espacios entonces guardará los datos.
         */
        if(!vehiculoDTO.getColorNuevo().isBlank() && !vehiculoDTO.getColorNuevo().equals(vehiculo.getColor())){
            vehiculo.setColor(vehiculoDTO.getColorNuevo());
        }
        if(!vehiculoDTO.getPlacasNuevas().isBlank() && !vehiculoDTO.getPlacasNuevas().equals(vehiculo.getPlacas())){
            vehiculo.setPlacas(vehiculoDTO.getPlacasNuevas());
        }
        return vehiculo;
    }
}
