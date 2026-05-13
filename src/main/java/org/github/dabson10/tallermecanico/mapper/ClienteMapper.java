package org.github.dabson10.tallermecanico.mapper;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    /**
     *Las dos siguientes funciones sirven para mapear ya sea de: <br>
     * --------- Cliente a ClienteSimpleDTO ------------- <br>
     * --------- ClienteSimpleDTO a Cliente -------------
     */
    Cliente paraCliente(ClienteSimpleDTO clienteDTO);
    ClienteSimpleDTO paraClienteSimpleDTO(Cliente cliente);

}
