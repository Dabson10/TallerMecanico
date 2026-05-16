package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioRequerimientoDTO;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;

public interface OrdenServiceImpl {
    OrdenServicioCompletoDTO crearOrden(OrdenServicioRequerimientoDTO orden);
    OrdenServicio traerOrden(Long id);
}
