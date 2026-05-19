package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteHistorialDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteMedioDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;

import java.util.List;

public interface ClienteServiceImpl {
    //Función para crear un cliente
    public ClienteSimpleDTO crearCliente(ClienteSimpleDTO cliente);

    //Función para listar clientes y sus vehiculos.
    List<ClienteMedioDTO> listarClientes();

    //Función para traer al cliente.
    ClienteHistorialDTO traerCliente(String correo);

    //Función para editar datos del cliente.
    ClienteSimpleDTO actualizarCliente();

    //Función para saber si el cliente existe.
    public Cliente existenciaCliente(String correo);
    Cliente buscarPorID(Long Id);
}
