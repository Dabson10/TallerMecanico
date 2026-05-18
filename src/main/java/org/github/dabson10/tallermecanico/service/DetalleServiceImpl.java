package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleNuevoDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;

public interface DetalleServiceImpl {
    DetalleOrden crearDetalles(DetalleNuevoDTO detalleOrden);
}
