package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleNuevoDTO;
import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.github.dabson10.tallermecanico.exceptions.RefaccionNotFoundException;
import org.github.dabson10.tallermecanico.repository.DetalleRepository;
import org.github.dabson10.tallermecanico.repository.RefaccionRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleService implements DetalleServiceImpl{
    //Inyección de dependencias.
    private final DetalleRepository deRe;
    private final RefaccionRepository reRe;
    private final OrdenService orRe;
    public DetalleService(DetalleRepository deRe, RefaccionRepository reRe,
                          OrdenService orRe){
        this.deRe = deRe;
        this.reRe = reRe;
        this.orRe = orRe;
    }
    @Override
    public DetalleOrden crearDetalles(DetalleNuevoDTO detalleOrden) {
        DetalleOrden detalles = new DetalleOrden();
        //Vamos a validar que exista la orden
        OrdenServicio orden = orRe.traerOrden(detalleOrden.getId_orden());
        //Teniendo el valor de los detalles toca validar si existen
        CatalogoRefaccion refaccion = reRe.findByNumero(detalleOrden.getNumero());
        if(refaccion == null){
            //Si es null entonces regresamos una excepción.
            throw new RefaccionNotFoundException("No se encontró la refacción");
        }
        //Guardamos la orden en los detalles y la refacción.
        detalles.setCantidad(detalleOrden.getCantidad());
        detalles.setPrecio_unitario(refaccion.getPrecioActual());
        detalles.setOrdenServicio(orden);
        detalles.setRefaccion(refaccion);
        return deRe.save(detalles);
    }
}
