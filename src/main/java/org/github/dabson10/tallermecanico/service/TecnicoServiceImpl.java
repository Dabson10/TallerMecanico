package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Tecnico;

public interface TecnicoServiceImpl {
    //Crea un nuevo tecnico.
    TecnicoSimpleDTO crearTecnico(TecnicoSimpleDTO tecnico);
    //Valida que el tecnico exista.
    Tecnico existenciaTecnico(String correo);
}
