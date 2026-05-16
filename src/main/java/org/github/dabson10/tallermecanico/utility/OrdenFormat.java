package org.github.dabson10.tallermecanico.utility;

import org.github.dabson10.tallermecanico.entity.Cliente;
import org.github.dabson10.tallermecanico.entity.Estados;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Esta clase sirve para formatear la clase de OrdenServicio para poder crear una orden nueva
 * esta es simplemente juntar los datos de dos clases cliente y Técnico
 */
@Component
public class OrdenFormat {
    public OrdenServicio crearOrden(Cliente cliente, Tecnico tecnico, String problema){
        OrdenServicio orden = new OrdenServicio();
        orden.setProblema(problema);
        orden.setCliente(cliente);
        orden.setTecnico(tecnico);
        orden.setFecha_registro(LocalDate.now());
        orden.setEstado(Estados.RECIBIDO);
        return orden;
    }
}
