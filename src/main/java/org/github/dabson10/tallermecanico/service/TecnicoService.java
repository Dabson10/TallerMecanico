package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoOrdenesDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoUpdateDataDTO;
import org.github.dabson10.tallermecanico.entity.Estados;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.github.dabson10.tallermecanico.exceptions.*;
import org.github.dabson10.tallermecanico.mapper.TecnicoMapper;
import org.github.dabson10.tallermecanico.repository.TecnicoRepository;
import org.github.dabson10.tallermecanico.utility.actualizarDatos.TecnicoDatosUpdate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService implements TecnicoServiceImpl {
    //Inyección de dependencias.
    private final TecnicoRepository teRe;
    private final TecnicoMapper teMa;
    private final TecnicoDatosUpdate teUp;
    public TecnicoService(TecnicoRepository teRe, TecnicoMapper teMa,
                          TecnicoDatosUpdate teUp){
        this.teRe = teRe; this.teMa = teMa;
        this.teUp = teUp;
    }
    @Override
    public TecnicoSimpleDTO crearTecnico(TecnicoSimpleDTO tecnico) {
        Tecnico tec = this.existenciaTecnico(tecnico.getCorreo());
        if(tec != null){
            throw new EntityDuplicateException("Técnico existente. Ingrese un correo diferente.");
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
        if(tecnico == null){throw new EntityNotFoundException("Técnico no encontrado.");}
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
    public TecnicoSimpleDTO tecnicoUpdate(TecnicoUpdateDataDTO tecnicoDTO) {
        Tecnico tecnico = this.existenciaTecnico(tecnicoDTO.getCorreo());
        //Validamos que el tecnico exista.
        if(tecnico == null){
            throw new EntityNotFoundException("Técnico no encontrado. Ingrese un corre de un técnico.");
        }
        //*Ahora realizamos el intercambio de datos antiguos con nuevos.
        tecnico = teUp.tecnicoUpdateData(tecnico, tecnicoDTO);
        //*Ahora guardamos.
        tecnico = teRe.save(tecnico);
        //*Ahora regresamos los valores pero en un DTO simplificado.
        return teMa.paraTecnicoSimpleDTO(tecnico);
    }

    @Override
    public TecnicoSimpleDTO tecnicoEstado(String correo) {
        Tecnico tecnico = this.existenciaTecnico(correo);
        //Validamos que el tecnico exista.
        if(tecnico == null){
            throw new EntityNotFoundException("No se encontró técnico con ese correo. Ingrese un correo existente.");
        }
        //Ahora teniendo el tecnico tenemos que hacer el cambio de estado.
        tecnico.setActivo(tecnico.cambioEstado());
        tecnico = teRe.save(tecnico);
        return teMa.paraTecnicoSimpleDTO(tecnico);
    }

    @Override
    public Tecnico existenciaTecnico(String correo) {
        return teRe.findByCorreo(correo).orElse(null);
    }
}
