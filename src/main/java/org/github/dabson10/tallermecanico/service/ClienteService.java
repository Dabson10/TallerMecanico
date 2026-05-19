package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteHistorialDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteMedioDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.github.dabson10.tallermecanico.exceptions.ClienteNotFoundException;
import org.github.dabson10.tallermecanico.exceptions.CorreoDuplicateException;
import org.github.dabson10.tallermecanico.mapper.ClienteMapper;
import org.github.dabson10.tallermecanico.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ClienteMedioDTO> listarClientes() {
        return cliMa.paraListaClienteMedio(cliRe.findAll());
    }

    @Override
    public ClienteHistorialDTO traerCliente(String correo) {
        Cliente cliente = this.existenciaCliente(correo);
        //Teniendo al cliente toca regresarlo sin antes formatearlo a la clase
        //clienteHistorialDTO
        if(cliente == null){
            throw new ClienteNotFoundException("No se encontró el cliente con ese correo.");
        }
        return cliMa.paraClienteHistorialDTO(cliente);
    }

    @Override
    public ClienteSimpleDTO actualizarCliente() {
        return null;
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

    @Override
    public Cliente buscarPorID(Long id) {
        return cliRe.findById(id).orElseThrow(() -> new ClienteNotFoundException("No se encontró el cliente."));
    }
}
