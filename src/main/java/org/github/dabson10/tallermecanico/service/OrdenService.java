package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioRequerimientoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenSinDetallesDTO;
import org.github.dabson10.tallermecanico.entity.*;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Este service es para la clase {@code OrdenServicioRepository}, para levantar órdenes nuevas de clientes o actualizarlas.
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

    /**
     * Esta función sirve para mostrar una orden y formatear los datos de la orden
     * @param id : Se hace una búsqueda mediante él, id de esta.
     * @return : Regresará los datos limpios y formateados.
     */
    @Override
    public OrdenServicioCompletoDTO mostrarOrden(Long id) {
        return orMa.paraOrdenServicioCompletoDTO(this.traerOrden(id));
    }

    @Override
    public List<OrdenSinDetallesDTO> listarOrdenes() {
        return orMa.paraOrdenesSinDetallesDTO(seRe.findAll());
    }

    @Override
    public List<OrdenSinDetallesDTO> ordenesCorreCliente(String correo) {
        List<OrdenServicio> orden = seRe.findOrdenServicioByCliente_Correo(correo);
        if(orden.isEmpty()){ throw new OrdenNotFoundException("El cliente no tiene ordenes."); }
        return orMa.paraOrdenesSinDetallesDTO(orden);
    }

    @Override
    public List<OrdenSinDetallesDTO> ordenesCorreoTecnico(String correo) {
        List<OrdenServicio> orden = seRe.findOrdenServicioByTecnico_CorreoAndEstadoNot(correo, Estados.ENTREGADO);
        if(orden.isEmpty()){ throw new OrdenNotFoundException("El técnico no tiene ordenes."); }
        return orMa.paraOrdenesSinDetallesDTO(orden);
    }

    @Override
    public List<OrdenSinDetallesDTO> ordenesEstado(Estados estados) {
        List<OrdenServicio> orden = seRe.findOrdenServicioByEstado(estados);
        if(orden.isEmpty()){ throw new OrdenNotFoundException("No se encontraron ordenes con ese estado."); }
        return orMa.paraOrdenesSinDetallesDTO(orden);
    }

    /**
     * Esta función sirve para buscar una orden y regresará un exception si no la encuentra.
     * @param id : Id de la orden
     * @return : Datos completos de la orden.
     */
    @Override
    public OrdenServicio traerOrden(Long id) {
        return seRe.findById(id).orElseThrow(() ->
                new OrdenNotFoundException("Orden no existente."));
    }
}
