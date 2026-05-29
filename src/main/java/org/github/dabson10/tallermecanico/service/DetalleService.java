package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleCantidadDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleNuevoDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetallesCompletoDTO;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.github.dabson10.tallermecanico.exceptions.CantidadNoValidaException;
import org.github.dabson10.tallermecanico.exceptions.EntityNotFoundException;
import org.github.dabson10.tallermecanico.exceptions.ListaVaciaException;
import org.github.dabson10.tallermecanico.mapper.DetallesMapper;
import org.github.dabson10.tallermecanico.repository.DetalleRepository;
import org.github.dabson10.tallermecanico.repository.RefaccionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DetalleService implements DetalleServiceImpl{
    //Inyección de dependencias.
    private final DetalleRepository deRe;
    private final RefaccionRepository reRe;
    private final OrdenService orRe;
    private final DetallesMapper deMa;
    public DetalleService(DetalleRepository deRe, RefaccionRepository reRe,
                          OrdenService orRe, DetallesMapper deMa){
        this.deRe = deRe;
        this.reRe = reRe;
        this.orRe = orRe;
        this.deMa = deMa;
    }
    @Override
    public DetallesCompletoDTO crearDetalles(DetalleNuevoDTO detalleOrden) {
        DetalleOrden detalles = new DetalleOrden();
        //Vamos a validar que exista la orden
        OrdenServicio orden = orRe.traerOrden(detalleOrden.getId_orden());
        if (orden == null) {
            throw new EntityNotFoundException("No se encontró la orden. Ingrese una correcta.");
        }
        //Teniendo el valor de los detalles toca validar si existen
        CatalogoRefaccion refaccion = reRe.findByNumero(detalleOrden.getNumero());
        if(refaccion == null){
            //Si es null entonces regresamos una excepción.
            throw new EntityNotFoundException("No se encontró la refacción. Ingrese una correcta.");
        }
        //Ahora restamos la cantidad en stock de la refacción con lo que se solicita
        Integer stock = refaccion.getStock();
        if(stock <= 0){
            throw new CantidadNoValidaException("No hay refacciones disponibles en stock");
        }
        //Ahora restamos el stock con la cantidad que se quiere obtener
        stock = stock - detalleOrden.getCantidad();
        System.out.println("Cantidad es: " + stock);
        if(stock < 0){
            throw new CantidadNoValidaException("No se junta la cantidad de refacciones que necesitas.");
        }
        //Ahora que ya tenemos el valor toca actualizar la columna de la base de datos con los nuevos datos.
        refaccion.setStock(stock);
        refaccion = reRe.save(refaccion);

        //Guardamos la orden en los detalles y la refacción.
        detalles.setCantidad(detalleOrden.getCantidad());
        detalles.setPrecio_unitario(refaccion.getPrecioActual());
        detalles.setOrdenServicio(orden);
        detalles.setRefaccion(refaccion);
        //Aquí regresamos el objeto formateado
        detalles = deRe.save(detalles);
        return deMa.paraDetallesCompletoDTO(detalles);
    }

    @Override
    public List<DetalleSimpleDTO> listarOrdenDetalles(Long id) {
        List<DetalleOrden> detalles = deRe.listarDetalles(id);
        detalles.forEach(p -> {
            System.out.println(p.toString());
        });
        if(detalles.isEmpty()){
            throw new ListaVaciaException("No hay detalles con ese id de orden.");
        }
        //Teniendo los datos toca regresar.
        return deMa.paraDetallesSimplesDTO(detalles);
    }

    @Override
    public Map<String, Float> calcularTotal(Long id) {
        //*Buscamos un detalle y validamos que exista.
        DetalleOrden detalle = deRe.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No se encontró detalle con ese ID."));
        //-Ahora obtenemos el total del producto.
        Float tot = detalle.getCantidad() * detalle.getPrecio_unitario();
        //*Ahora regresamos un mapa con los datos formateados.
        return Map.of("Total ", tot);
    }

    @Override
    public DetalleSimpleDTO cambiarCantidad(DetalleCantidadDTO detalle) {
        //Validamos que
        DetalleOrden detalleO = deRe.findById(detalle.getId_detalle_orden()).orElseThrow(
                () -> new EntityNotFoundException("No se encontró detalle con ese ID."));
        return null;
    }
}
