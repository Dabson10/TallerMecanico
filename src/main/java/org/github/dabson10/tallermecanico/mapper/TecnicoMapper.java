package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoOrdenesDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrdenServicioMapper.class})
public interface TecnicoMapper {

    /**
     * Las siguientes funciones son para mapear de: <br>
     * ------------ Tecnico a TecnicoSimpleDTO ------------- <br>
     * ------------ TecnicoSimpleDTO a Tecnico -------------
     */
    Tecnico paraTecnico(TecnicoSimpleDTO tecnicoDTO);
    TecnicoSimpleDTO paraTecnicoSimpleDTO(Tecnico tecnico);

    List<TecnicoSimpleDTO> paraTecnicosSimpleDTO(List<Tecnico> tecnicos);

    /**
     * Las siguientes funciones son para mapear de:<br>
     * ------------ Tecnico a TecnicoCompletDTO ------------- <br>
     * ------------ TecnicoCompletoDTO a Tecnico -------------
     */



    TecnicoOrdenesDTO paraTecnicoOrdenesDTO(Tecnico tecnico);
}
