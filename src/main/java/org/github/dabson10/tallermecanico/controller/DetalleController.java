package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleNuevoDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetallesCompletoDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.github.dabson10.tallermecanico.service.DetalleService;
import org.github.dabson10.tallermecanico.utility.OrdenFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detail")
public class DetalleController {
    //Inyección de dependencias.
    private final DetalleService deSe;
    public DetalleController(DetalleService deSe){
        this.deSe = deSe;
    }

    @PostMapping("/create")
    public ResponseEntity<DetallesCompletoDTO> crearOrden(
            @Valid @RequestBody DetalleNuevoDTO detalle
            ){
        DetallesCompletoDTO det = deSe.crearDetalles(detalle);
        return new ResponseEntity<>(det, HttpStatus.CREATED);
    }

}
