package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.tecnico.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Tecnico;

public interface TecnicoServiceImpl {
    //Crea un nuevo tecnico.
    TecnicoSimpleDTO crearTecnico(TecnicoSimpleDTO tecnico);
    //Valida que el tecnico exista.
    Tecnico existenciaTecnico(String correo);
}
