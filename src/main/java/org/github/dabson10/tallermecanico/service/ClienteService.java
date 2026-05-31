package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteHistorialDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteMedioDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteSimpleDTO;
import org.github.dabson10.tallermecanico.dto.clienteDTO.ClienteUpdateDTO;
import org.github.dabson10.tallermecanico.entity.Cliente;
import org.github.dabson10.tallermecanico.exceptions.EntityDuplicateException;
import org.github.dabson10.tallermecanico.exceptions.EntityNotFoundException;
import org.github.dabson10.tallermecanico.mapper.ClienteMapper;
import org.github.dabson10.tallermecanico.repository.ClienteRepository;
import org.github.dabson10.tallermecanico.utility.actualizarDatos.DatosClienteUpdate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ClienteServiceImpl{
    //Inyección de dependencias.
    private final ClienteRepository cliRe;
    private final ClienteMapper cliMa;
    private final DatosClienteUpdate cliUp;
    public ClienteService(ClienteRepository cliRe, ClienteMapper cliMa,
                          DatosClienteUpdate cliUp){
        this.cliRe= cliRe;
        this.cliMa = cliMa;
        this.cliUp = cliUp;
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
            throw new EntityDuplicateException("Cliente existe. Ingrese un correo diferente.");
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
            throw new EntityNotFoundException("No se encontró el cliente con ese correo.");
        }
        return cliMa.paraClienteHistorialDTO(cliente);
    }

    @Override
    public ClienteSimpleDTO actualizarCliente(ClienteUpdateDTO cliente) {
        //Obtenemos el cliente mediante su correo electronico.
        Cliente client = this.existenciaCliente(cliente.getCorreo());
        if (client == null) {
            throw new EntityNotFoundException("Cliente no encontrado. Ingrese un cliente existente.");
        }
        //Creamos un objeto de clienteSimple con los datos del cliente obtenidos de la base de datos.
        ClienteSimpleDTO clienteDTO = cliMa.paraClienteSimpleDTO(client);
        //Ahora ya teniendo los valores en clienteSimple toca formatear los datos para actualizar.
        clienteDTO = cliUp.actualizarDatosCliente(clienteDTO, cliente);
        //Realizamos el guardado o actualización en el objeto cliente.
        client = cliRe.save(cliMa.paraCliente(clienteDTO));
        //Regresamos el valor formateado a clienteSimple.
        return cliMa.paraClienteSimpleDTO(client);
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
        return cliRe.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el cliente."));
    }
}
