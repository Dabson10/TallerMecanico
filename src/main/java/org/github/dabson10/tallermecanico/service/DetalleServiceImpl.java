package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleCantidadDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleNuevoDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetallesCompletoDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;

import java.util.List;
import java.util.Map;

public interface DetalleServiceImpl {
    //Función para crear detalles.
    DetallesCompletoDTO crearDetalles(DetalleNuevoDTO detalleOrden);
    //Función listar todos los detalles de una orden.
    List<DetalleSimpleDTO> listarOrdenDetalles(Long id);
    //Calcular el total de un detalle.
    Map<String, Float> calcularTotal(Long id);
    //Esta funciona para cambiar la cantidad de un producto y asi no hace otras órdenes.
    DetalleSimpleDTO cambiarCantidad(DetalleCantidadDTO detalle);
}
