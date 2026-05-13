package org.github.dabson10.tallermecanico.utility.clienteFormat;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.springframework.stereotype.Component;

/**
 * Esta clase sirve para formatear ya sea de la clase {@code Cliente } a {@code ClienteSimpleDTO} y viceversa.
 */
@Component
public class ClienteFormatSimple {

    //=================== Cliente -> ClienteSimpleDTO ==================
    public ClienteSimpleDTO clienteDtoFormatData(Cliente cliente){
        ClienteSimpleDTO clienteDTO = new ClienteSimpleDTO();
        clienteDTO.setId_cliente(cliente.getId_cliente());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setCorreo(cliente.getCorreo());
        return clienteDTO;
    }


    //=================== ClienteSimpleDTO -> Cliente ==================
    public Cliente clienteFormatData(ClienteSimpleDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId_cliente(clienteDTO.getId_cliente());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setCorreo(clienteDTO.getCorreo());
        return cliente;
    }
}
