package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCompletoDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCreateDTO;
import org.github.dabson10.tallermecanico.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class VehiculoController {
    //Inyección de dependencias.
    private final VehiculoService veSe;
    public VehiculoController(VehiculoService veSe){
        this.veSe = veSe;
    }

    @PostMapping("/create")
    public ResponseEntity<VehiculoCompletoDTO> crearVehiculo(
            @Valid @RequestBody VehiculoCreateDTO vehiculo
    ){
      VehiculoCompletoDTO car = veSe.crearVehiculo(vehiculo);
      return new ResponseEntity<>(car, HttpStatus.CREATED);
    }


    //Listar los vehiculos
    @GetMapping("/list")
    public ResponseEntity<List<VehiculoCompletoDTO>> listarVehiculos(){
        List<VehiculoCompletoDTO> lista = veSe.traerVehiculos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{placas}/get")
    public ResponseEntity<VehiculoCompletoDTO> traerVehiculo(
            @Validated @PathVariable String placas
    ){
        VehiculoCompletoDTO vehiculo = veSe.traerVehiculo(placas);
        return new ResponseEntity<>(vehiculo, HttpStatus.OK);
    }

}
