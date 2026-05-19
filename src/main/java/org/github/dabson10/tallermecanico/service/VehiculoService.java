package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCompletoDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCreateDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.github.dabson10.tallermecanico.exceptions.ClienteConVehiculoException;
import org.github.dabson10.tallermecanico.exceptions.ClienteNotFoundException;
import org.github.dabson10.tallermecanico.exceptions.VehiculoDuplicateException;
import org.github.dabson10.tallermecanico.exceptions.VehiculoNotFoundException;
import org.github.dabson10.tallermecanico.mapper.ClienteMapper;
import org.github.dabson10.tallermecanico.mapper.VehiculoMapper;
import org.github.dabson10.tallermecanico.repository.ClienteRepository;
import org.github.dabson10.tallermecanico.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements VehiculoServiceImpl{
    //Inyección de dependencias.
    private final VehiculoRepository veRe;
    private final VehiculoMapper veMa;
    private final ClienteRepository cliRe;
    private final ClienteMapper cliMa;
    public VehiculoService(VehiculoRepository veRe, VehiculoMapper veMa,
                           ClienteRepository cliRe, ClienteMapper cliMa){
        this.veRe = veRe; this.veMa = veMa;
        this.cliRe = cliRe;this.cliMa = cliMa;
    }

    /**
     * Esta función sirve para crear un vehículo, mediante la clase simple
     * @param vehiculo : Datos del nuevo vehículo
     * @return : Regresará la clase simple con los datos guardados de la base de datos.
     */
    @Override
    public VehiculoCompletoDTO crearVehiculo(VehiculoCreateDTO vehiculo) {
        Vehiculo vehi = this.existenciaVehiculo(vehiculo.getPlacas());
        if(vehi != null){
            //Si se encontró algún usuario entonces regresamos
            throw new VehiculoDuplicateException("Placas de vehiculo existente.");
        }
        //Obtenemos al cliente dueño del carro, pero si no lo encuentrá muestra una excepción
        Cliente cliente = cliRe.findByCorreo(vehiculo.getCorreoCliente()).orElseThrow(() ->
                new ClienteNotFoundException("Cliente no encontrado."));
        //Ahora validamos que el cliente no tenga un vehículo asociado.
        if(cliente.getVehiculo() != null){
            //Si es diferente a null entonces regreso una excepción.
            throw new ClienteConVehiculoException("El cliente ya cuenta con un vehículo.");
        }
        //Creamos el objeto que contendrá los valores del vehículo, obviamente en un DTO.
        VehiculoCompletoDTO vehiculoDTO = veMa.paraDTOCompleto(vehiculo);
        vehiculoDTO.setCliente(cliMa.paraClienteSimpleDTO(cliente));
        //Ahora validamos que el cliente exista.
        vehi = veRe.save(veMa.paraVehiculoCompleto(vehiculoDTO));
        return veMa.paraVehiculoCompletoDTO(vehi);
    }

    @Override
    public List<VehiculoCompletoDTO> traerVehiculos() {
        return veMa.paraVehiculosCompletosDTO(veRe.findAll());
    }

    @Override
    public VehiculoCompletoDTO traerVehiculo(String placa) {
        Vehiculo vehiculo = this.existenciaVehiculo(placa);
        if(vehiculo == null){ throw new VehiculoNotFoundException("Vehiculo no encontrado.");}
        //Ahora regresamos el objeto sin antes formatearlo.
        return veMa.paraVehiculoCompletoDTO(vehiculo);
    }

    @Override
    public Vehiculo existenciaVehiculo(String placas) {
        return veRe.findByPlacas(placas).orElse(null);
    }
}
