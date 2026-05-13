package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.tecnico.TecnicoSimpleDTO;
import org.github.dabson10.tallermecanico.service.TecnicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
