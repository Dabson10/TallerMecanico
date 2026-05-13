package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.tecnico.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {

    /**
     * Las siguientes funciones son para mapear de: <br>
     * ------------ Tecnico a TecnicoSimpleDTO ------------- <br>
     * ------------ TecnicoSimpleDTO a Tecnico -------------
     */
    Tecnico paraTecnico(TecnicoSimpleDTO tecnicoDTO);
    TecnicoSimpleDTO paraTecnicoSimpleDTO(Tecnico tecnico);
    /**
     * Las siguientes funciones son para mapear de:<br>
     * ------------ Tecnico a TecnicoCompletDTO ------------- <br>
     * ------------ TecnicoCompletoDTO a Tecnico -------------
     */
}
