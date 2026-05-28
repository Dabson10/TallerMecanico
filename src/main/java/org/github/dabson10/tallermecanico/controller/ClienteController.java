package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteHistorialDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteMedioDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteUpdateDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.github.dabson10.tallermecanico.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClienteController {

    //Inyección de dependencia.
    private final ClienteService cliSe;
    public ClienteController(ClienteService cliSe){
        this.cliSe = cliSe;
    }

    //Controladores.

    /**
     * Controlador para crear un nuevo cliente con base a datos fundamentales
     * @param cliente : Los datos necesarios del cliente.
     * @return : Regresará los mismos datos, pero ahora regresará él, id del cliente guardado
     */
    @PostMapping("/create")
    public ResponseEntity<ClienteSimpleDTO> crearUsuario(
           @Valid @RequestBody ClienteSimpleDTO cliente
    ){
        ClienteSimpleDTO cli = cliSe.crearCliente(cliente);
        return new ResponseEntity<>(cli, HttpStatus.CREATED);
    }

    /**
     * Función que traerá todos los clientes.
     * @return : Regresará un JSON con los clientes en un formato específico.
     */
    @GetMapping("/list")
    public ResponseEntity<List<ClienteMedioDTO>> listarClientes(){
        List<ClienteMedioDTO> clientes = cliSe.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ClienteSimpleDTO> actualizarCliente
            (@Valid @RequestBody ClienteUpdateDTO cliente){
        ClienteSimpleDTO clienteDTO = cliSe.actualizarCliente(cliente);
        return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
    }

    /**
     * Controlador para buscar un cliente, sus vehículos y sus órdenes.
     * @param correo : Correo electrónico del cliente.
     * @return : Regresará en formato JSON los datos del cliente y sus órdenes
     */
    @GetMapping("/{correo}/get")
    public ResponseEntity<ClienteHistorialDTO> traerCliente(
            @Validated @PathVariable String correo
    ){
        ClienteHistorialDTO cliente = cliSe.traerCliente(correo);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
