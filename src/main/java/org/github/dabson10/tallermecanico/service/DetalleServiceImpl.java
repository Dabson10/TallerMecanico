package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleNuevoDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetallesCompletoDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;

public interface DetalleServiceImpl {
    DetallesCompletoDTO crearDetalles(DetalleNuevoDTO detalleOrden);
}
