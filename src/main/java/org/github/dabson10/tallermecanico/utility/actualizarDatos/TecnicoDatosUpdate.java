package org.github.dabson10.tallermecanico.utility.actualizarDatos;

import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoUpdateDataDTO;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.springframework.stereotype.Component;

@Component
public class TecnicoDatosUpdate {
    public Tecnico tecnicoUpdateData(Tecnico tecnico, TecnicoUpdateDataDTO tecnicoDTO){
        if(!tecnicoDTO.getCorreoNuevo().isBlank() && !tecnicoDTO.getCorreoNuevo().equals(tecnico.getCorreo())){
            tecnico.setCorreo(tecnicoDTO.getCorreoNuevo());
        }
        if(!tecnicoDTO.getNombreNuevo().isBlank() && !tecnicoDTO.getNombreNuevo().equals(tecnico.getNombre())){
            tecnico.setNombre(tecnicoDTO.getNombreNuevo());
        }
        return tecnico;
    }
}
