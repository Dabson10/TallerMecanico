package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioCompletoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioRequerimientoDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioSimpleDTO;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenSinDetallesDTO;
import org.github.dabson10.tallermecanico.enums.Estados;
import org.github.dabson10.tallermecanico.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Lista todas las ordenes sin detalles en cada una.
    @GetMapping("/list")
    public ResponseEntity<List<OrdenSinDetallesDTO>> listOrdenesSinDetalles(){
        List<OrdenSinDetallesDTO> ordenes = orSe.listarOrdenes();
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    //Busca una orden con el correo del cliente
    @GetMapping("/cliente")
    public ResponseEntity<List<OrdenSinDetallesDTO>> ordenesCliente(
            @RequestParam(name = "correo", required = true) String correo
    ){
        List<OrdenSinDetallesDTO> lista = orSe.ordenesCorreCliente(correo);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    //Buscar un técnico mediante su correo electrónico.
    @GetMapping("/tecnico")
    public ResponseEntity<List<OrdenSinDetallesDTO>> ordenesTecnico(
            @RequestParam (name = "correo", required = true) String correo
    ){
        List<OrdenSinDetallesDTO> ordenes = orSe.ordenesCorreoTecnico(correo);
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    //Buscar ordenes mediante su estado.
    @GetMapping("/estatus/{estado}")
    public ResponseEntity<List<OrdenSinDetallesDTO>> ordenesEstado(
            @Validated @PathVariable Estados estado
            ){
        List<OrdenSinDetallesDTO> ordenes = orSe.ordenesEstado(estado);
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrdenServicioSimpleDTO> cambiarEstadoOrden(
            @Validated @PathVariable Long id
    ){
        OrdenServicioSimpleDTO orden = orSe.actaulizarEstado(id);
        return new ResponseEntity<>(orden, HttpStatus.OK);
    }


}
