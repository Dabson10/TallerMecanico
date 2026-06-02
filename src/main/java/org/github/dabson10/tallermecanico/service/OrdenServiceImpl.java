package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioRequerimientoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioSimpleDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenSinDetallesDTO;
import org.github.dabson10.tallermecanico.enums.Estados;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;

import java.util.List;

public interface OrdenServiceImpl {
    //Crea una orden nueva.
    OrdenServicioCompletoDTO crearOrden(OrdenServicioRequerimientoDTO orden);
    //Muestra una orden mediante su id.
    OrdenServicioCompletoDTO mostrarOrden(Long id);
    //Lista todas las órdenes, pero omite los detalles de esta.
    List<OrdenSinDetallesDTO> listarOrdenes();
    //Buscar una orden mediante el correo del cliente.
    List<OrdenSinDetallesDTO> ordenesCorreCliente(String correo);
    //Busca órdenes de técnicos mediante el correo.
    List<OrdenSinDetallesDTO> ordenesCorreoTecnico(String correo);
    //Busca ordenes con cierto estado.
    List<OrdenSinDetallesDTO> ordenesEstado(Estados estados);
    //Actualiza el estado en la orden.
    OrdenServicioSimpleDTO actaulizarEstado(Long id);

    //Traer una orden mediante su ID//Sirve para validar existencias.
    OrdenServicio traerOrden(Long id);
}
