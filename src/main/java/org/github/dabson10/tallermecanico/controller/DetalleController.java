package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleCantidadDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleNuevoDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetallesCompletoDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.github.dabson10.tallermecanico.service.DetalleService;
import org.github.dabson10.tallermecanico.utility.OrdenFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}/service")
    public ResponseEntity<List<DetalleSimpleDTO>> listaDetallesOrden(
            @Validated @PathVariable Long id
    ){
        List<DetalleSimpleDTO> detalles = deSe.listarOrdenDetalles(id);
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @GetMapping("/{ID}/total")
    public ResponseEntity<Map<String, Float>> totalDetalle(
            @Validated @PathVariable Long ID
    ){
        Map<String, Float> total = deSe.calcularTotal(ID);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    //Controller para cambiar la cantidad del de productos en el detalle.
    @PutMapping("/cant")
    public ResponseEntity<DetalleSimpleDTO> cambiarCantidad(
            @Valid @RequestBody DetalleCantidadDTO detalle
            ){
        DetalleSimpleDTO detalleDTO = deSe.cambiarCantidad(detalle);
        return new ResponseEntity<>(detalleDTO, HttpStatus.OK);
    }
}
