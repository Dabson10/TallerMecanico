package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;

public interface ClienteServiceImpl {
    //Función para crear un cliente
    public ClienteSimpleDTO crearCliente(ClienteSimpleDTO cliente);

    //Función para saber si el cliente existe.
    public Cliente existenciaCliente(String correo);
}
