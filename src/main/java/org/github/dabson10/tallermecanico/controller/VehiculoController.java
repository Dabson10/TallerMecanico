package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCompletoDTO;
import org.github.dabson10.tallermecanico.dto.vehiculoDTO.VehiculoCreateDTO;
import org.github.dabson10.tallermecanico.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
