package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteHistorialDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteMedioDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrdenServicioMapper.class})
public interface ClienteMapper {

    /**
     *Las dos siguientes funciones sirven para mapear ya sea de: <br>
     * --------- Cliente a ClienteSimpleDTO ------------- <br>
     * --------- ClienteSimpleDTO a Cliente -------------
     */
    Cliente paraCliente(ClienteSimpleDTO clienteDTO);
    ClienteSimpleDTO paraClienteSimpleDTO(Cliente cliente);


    ClienteHistorialDTO paraClienteHistorialDTO(Cliente cliente);

    List<ClienteMedioDTO> paraListaClienteMedio(List<Cliente> clientes);
}
