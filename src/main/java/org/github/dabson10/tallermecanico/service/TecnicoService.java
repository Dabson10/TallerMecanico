package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoOrdenesDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Estados;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.github.dabson10.tallermecanico.exceptions.CorreoDuplicateException;
import org.github.dabson10.tallermecanico.exceptions.OrdenesEmptyException;
import org.github.dabson10.tallermecanico.exceptions.TecnicoNotFoundException;
import org.github.dabson10.tallermecanico.mapper.TecnicoMapper;
import org.github.dabson10.tallermecanico.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<TecnicoSimpleDTO> listarTecnicos() {
        return teMa.paraTecnicosSimpleDTO(teRe.findAll());
    }

    @Override
    public TecnicoOrdenesDTO obtenerTecnico(String correo) {
        //Obtenemos el correo y hacemos una validación
        Tecnico tecnico = this.existenciaTecnico(correo);
        if(tecnico == null){throw new TecnicoNotFoundException("Técnico no encontrado.");}
        //Ahora teniendo al tecnico filtramos sus órdenes. Sin antes validar que al menos tenga una.
        if(tecnico.getOrdenes().isEmpty()){
            //Si está vacío entonces regresamos.
            throw new OrdenesEmptyException("El técnico no tiene ordenes asignadas.");
        }
        //Filtramos la lista de órdenes a las órdenes que aún no se han entregado.
        List<OrdenServicio> ordenFiltro = tecnico.getOrdenes().stream()
                .filter(orden -> !orden.getEstado().equals(Estados.ENTREGADO)).toList();
        //Ahora toca mapear los datos de Tecnico a TecnicoOrdenDTO.
        tecnico.setOrdenes(ordenFiltro);
        return teMa.paraTecnicoOrdenesDTO(tecnico);
    }

    @Override
    public Tecnico existenciaTecnico(String correo) {
        return teRe.findByCorreo(correo).orElse(null);
    }
}
