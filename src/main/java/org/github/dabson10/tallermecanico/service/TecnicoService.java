package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.github.dabson10.tallermecanico.exceptions.CorreoDuplicateException;
import org.github.dabson10.tallermecanico.mapper.TecnicoMapper;
import org.github.dabson10.tallermecanico.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService implements TecnicoServiceImpl {
    //Inyección de dependencias.
    private final TecnicoRepository teRe;
    private final TecnicoMapper teMa;
    public TecnicoService(TecnicoRepository teRe, TecnicoMapper teMa){
        this.teRe = teRe;
        this.teMa = teMa;
    }
    @Override
    public TecnicoSimpleDTO crearTecnico(TecnicoSimpleDTO tecnico) {
        Tecnico tec = this.existenciaTecnico(tecnico.getCorreo());
        if(tec != null){
            throw new CorreoDuplicateException("Ingrese un correo diferente.");
        }
        tec = teRe.save(teMa.paraTecnico(tecnico));
        return teMa.paraTecnicoSimpleDTO(tec);
    }

    @Override
    public Tecnico existenciaTecnico(String correo) {
        return teRe.findByCorreo(correo).orElse(null);
    }
}
