package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoCompletoDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoOrdenesDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoUpdateDataDTO;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.github.dabson10.tallermecanico.service.TecnicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tech")
public class TecnicoController {
    //Inyección de dependencias.
    private final TecnicoService teSe;
    public TecnicoController(TecnicoService teSe){
        this.teSe = teSe;
    }

    @PostMapping("/create")
    public ResponseEntity<TecnicoSimpleDTO> crearTecnico(
            @Valid @RequestBody TecnicoSimpleDTO tecnico
    ){
        tecnico = teSe.crearTecnico(tecnico);
        return new ResponseEntity<>(tecnico, HttpStatus.CREATED);
    }


    @GetMapping("/list")
    public ResponseEntity<List<TecnicoSimpleDTO>> listarTecnicos(){
        List<TecnicoSimpleDTO> lista = teSe.listarTecnicos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{correo}/get")
    public ResponseEntity<TecnicoOrdenesDTO> obtenerTecnico(
            @Validated @PathVariable String correo
    ){
        TecnicoOrdenesDTO tecnico = teSe.obtenerTecnico(correo);
        return new ResponseEntity<>(tecnico, HttpStatus.OK);
    }

    @GetMapping("/log")
    public ResponseEntity<TecnicoCompletoDTO> logTecnico(
            @RequestParam(required = true, name = "correo") String correo) {
        TecnicoCompletoDTO tec = teSe.logTecnico(correo);
        return new ResponseEntity<>(tec, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<TecnicoSimpleDTO> actualizarTecnico(
            @Valid @RequestBody TecnicoUpdateDataDTO tecnicoDTO
            ){
        TecnicoSimpleDTO tecnico = teSe.tecnicoUpdate(tecnicoDTO);
        return new ResponseEntity<>(tecnico, HttpStatus.OK);
    }

    @PatchMapping("/status")
    public ResponseEntity<TecnicoSimpleDTO> actualizarEstado(
            @Validated @Email(message = "Ingrese un correo valido.")
            @RequestParam String correo
    ){
        TecnicoSimpleDTO tecnico = teSe.tecnicoEstado(correo);
        return new ResponseEntity<>(tecnico, HttpStatus.OK);
    }



}
