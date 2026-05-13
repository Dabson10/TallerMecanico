package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.github.dabson10.tallermecanico.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    //Inyección de dependencia.
    private final ClienteService cliSe;
    public ClienteController(ClienteService cliSe){
        this.cliSe = cliSe;
    }

    //Controladores.
    @PostMapping("/create")
    public ResponseEntity<ClienteSimpleDTO> crearUsuario(
           @Valid @RequestBody ClienteSimpleDTO cliente
    ){
        ClienteSimpleDTO cli = cliSe.crearCliente(cliente);
        return new ResponseEntity<>(cli, HttpStatus.CREATED);
    }



}
