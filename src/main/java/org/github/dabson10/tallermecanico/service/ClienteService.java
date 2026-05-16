package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.github.dabson10.tallermecanico.exceptions.CorreoDuplicateException;
import org.github.dabson10.tallermecanico.mapper.ClienteMapper;
import org.github.dabson10.tallermecanico.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteServiceImpl{
    //Inyección de dependencias.
    private final ClienteRepository cliRe;
    private final ClienteMapper cliMa;

    public ClienteService(ClienteRepository cliRe, ClienteMapper cliMa){
        this.cliRe= cliRe;
        this.cliMa = cliMa;
    }

    /**
     * Función para crear un usuario
     * @param cliente : Datos del cliente.
     */
    @Override
    public ClienteSimpleDTO crearCliente(ClienteSimpleDTO cliente) {
        Cliente cli = this.existenciaCliente(cliente.getCorreo());
        if(cli != null){
            //Si es diferente a null significa que existe el cliente, por lo que no crearemos al usuario
            throw new CorreoDuplicateException("Correo existente, ingrese uno diferente.");
        }
        cli = cliRe.save(cliMa.paraCliente(cliente));
        return cliMa.paraClienteSimpleDTO(cli);
    }

    /**
     * Función para buscar un cliente mediante su correo electrónico.
     * @param correo : Correo del cliente.
     * @return : Regresara el cliente si lo encontró o un null.
     */
    @Override
    public Cliente existenciaCliente(String correo) {
        return cliRe.findByCorreo(correo).orElse(null);
    }
}
