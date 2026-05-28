package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoOrdenesDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoUpdateDataDTO;
import org.github.dabson10.tallermecanico.entity.Tecnico;

import java.util.List;

public interface TecnicoServiceImpl {
    //Crea un nuevo tecnico.
    TecnicoSimpleDTO crearTecnico(TecnicoSimpleDTO tecnico);
    //Listar los técnicos.
    List<TecnicoSimpleDTO> listarTecnicos();
    TecnicoOrdenesDTO obtenerTecnico(String correo);
    //Actualizar datos del tecnico.
    TecnicoSimpleDTO tecnicoUpdate(TecnicoUpdateDataDTO tecnicoDTO);
    //Actualizar estado de activo del tecnico.
    TecnicoSimpleDTO tecnicoEstado(String correo);
    //Válida que el tecnico exista.
    Tecnico existenciaTecnico(String correo);
}
