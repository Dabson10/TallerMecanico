package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioRequerimientoDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.github.dabson10.tallermecanico.exceptions.ClienteNotFoundException;
import org.github.dabson10.tallermecanico.exceptions.OrdenNotFoundException;
import org.github.dabson10.tallermecanico.exceptions.TecnicoNotFoundException;
import org.github.dabson10.tallermecanico.exceptions.VehiculoNotFoundException;
import org.github.dabson10.tallermecanico.mapper.OrdenServicioMapper;
import org.github.dabson10.tallermecanico.repository.ClienteRepository;
import org.github.dabson10.tallermecanico.repository.OrdenServicioRepository;
import org.github.dabson10.tallermecanico.repository.TecnicoRepository;
import org.github.dabson10.tallermecanico.utility.OrdenFormat;
import org.springframework.stereotype.Service;

/**
 * Este service es para la clase {@code OrdenService}, para levantar órdenes nuevas de clientes o actualizarlas.
 */
@Service
public class OrdenService implements OrdenServiceImpl{
    //Inyección de dependencias.
    private final OrdenServicioRepository seRe;
    private final ClienteRepository cliRe;
    private final TecnicoRepository teRe;
    private final OrdenFormat orFor;
    private final OrdenServicioMapper orMa;
    public OrdenService(OrdenServicioRepository seRe, ClienteRepository cliRe,
                        TecnicoRepository teRe, OrdenFormat orFor,
                        OrdenServicioMapper orMa){
        this.seRe = seRe;
        this.cliRe = cliRe;
        this.teRe = teRe;
        this.orFor = orFor;
        this.orMa = orMa;
    }

    /**
     *Esta función sirve para crear una nueva orden con los atributos
     * necesarios para levantar una orden como correo de cliente y técnico, junto con el problema.
     * @param orden : Clase DTO con los atributos necesarios.
     * @return : Regresará el objeto completo.
     */
    @Override
    public OrdenServicioCompletoDTO crearOrden(OrdenServicioRequerimientoDTO orden) {
        //Obtenemos el correo del cliente y técnico y si no se encuentra entonces regresamos una excepción.
        Cliente cliente = cliRe.findByCorreo(orden.getCorreoCliente()).orElseThrow(() ->
                new ClienteNotFoundException("Cliente no encontrado."));
        Tecnico tecnico = teRe.findByCorreo(orden.getCorreoTecnico()).orElseThrow(() ->
                new TecnicoNotFoundException("Técnico no encontrado."));

        Vehiculo vehiculo = cliente.getVehiculo();
        if(vehiculo == null){
            //Si no hay vehiculo regresamos una excepción
            throw new VehiculoNotFoundException("No hay un vehiculo asociado con el cliente.");
        }

        //Creamos la orden, la guardamos en la base de datos y la regresamos.
        OrdenServicio ordenSe = seRe.save(orFor.crearOrden(cliente, tecnico, orden.getProblema()));
        return orMa.paraOrdenServicioCompletoDTO(ordenSe);
    }

    @Override
    public OrdenServicio traerOrden(Long id) {
        return seRe.findById(id).orElseThrow(() ->
                new OrdenNotFoundException("Orden no existente."));
    }
}
