package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioRequerimientoDTO;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.github.dabson10.tallermecanico.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class OrdenServicioController {
    //Inyección de dependencias.
    private final OrdenService orSe;
    public OrdenServicioController(OrdenService orSe){
        this.orSe = orSe;
    }

    @PostMapping("/create")
    public ResponseEntity<OrdenServicioCompletoDTO> crearOrdenes(
            @Valid @RequestBody OrdenServicioRequerimientoDTO ordenSer
            ){
        OrdenServicioCompletoDTO orden = orSe.crearOrden(ordenSer);
        return new ResponseEntity<>(orden, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<OrdenServicioCompletoDTO> traerOrden(
            @Validated @PathVariable Long id
    ){
        OrdenServicioCompletoDTO orden = orSe.mostrarOrden(id);
        return new ResponseEntity<>(orden, HttpStatus.OK);
    }


}
