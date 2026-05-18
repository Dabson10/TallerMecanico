package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioRequerimientoDTO;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;

public interface OrdenServiceImpl {
    OrdenServicioCompletoDTO crearOrden(OrdenServicioRequerimientoDTO orden);
    OrdenServicioCompletoDTO mostrarOrden(Long id);
    OrdenServicio traerOrden(Long id);
}
