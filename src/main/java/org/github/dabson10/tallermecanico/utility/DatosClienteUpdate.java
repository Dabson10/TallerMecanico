package org.github.dabson10.tallermecanico.utility;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class DatosClienteUpdate {
    public ClienteSimpleDTO actualizarDatosCliente(ClienteSimpleDTO clienteDTO, ClienteUpdateDTO cliente){
        /*
         * La forma en la que se actualizaran los datos es comparar el valor del cliente y si es diferente a la del DTO
         * y el valor del cliente no es vacío entonces guardamos el nuevo dato
         */
        if(!cliente.getNombreNuevo().equals(clienteDTO.getNombre()) && !cliente.getNombreNuevo().isBlank()){
            //Si no está vacio entonces guardamos
            clienteDTO.setNombre(cliente.getNombreNuevo());
        }
        if(!cliente.getApellidoNuevo().equals(clienteDTO.getApellido()) && !cliente.getApellidoNuevo().isBlank()){
            clienteDTO.setApellido(cliente.getApellidoNuevo());
        }
        if(!cliente.getTelefonoNuevo().equals(clienteDTO.getTelefono()) && !cliente.getTelefonoNuevo().isBlank()){
            clienteDTO.setTelefono(cliente.getTelefonoNuevo());
        }
        if(!cliente.getCorreoNuevo().equals(clienteDTO.getCorreo()) && !cliente.getCorreoNuevo().isBlank()){
            clienteDTO.setCorreo(cliente.getCorreoNuevo());
        }
        return clienteDTO;
    }
}
