package org.github.dabson10.tallermecanico.service;

import lombok.extern.slf4j.Slf4j;
import org.github.dabson10.tallermecanico.dto.refaccionDTO.RefaccionUpdateDTO;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.github.dabson10.tallermecanico.exceptions.CantidadNoValidaException;
import org.github.dabson10.tallermecanico.exceptions.EntityDuplicateException;
import org.github.dabson10.tallermecanico.exceptions.EntityNotFoundException;
import org.github.dabson10.tallermecanico.repository.RefaccionRepository;
import org.github.dabson10.tallermecanico.utility.actualizarDatos.RefaccionDatosUpdate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RefaccionService implements RefaccionServiceImpl{
    //Inyección de dependencias.
    private final RefaccionRepository reRe;
    private final DetalleOrden deOr;
    private final RefaccionDatosUpdate reUp;
    public RefaccionService(RefaccionRepository reRe, RefaccionDatosUpdate reUp,
                            DetalleOrden deOr){
        this.reRe = reRe;
        this.reUp = reUp;
        this.deOr = deOr;
    }

    @Override
    public CatalogoRefaccion crearRefaccion(CatalogoRefaccion refaccion) {
        CatalogoRefaccion ref = this.existenciaRefaccion(refaccion.getNumero());
        if(ref != null){
            //Si existe la refacción mostramos una exception.
            throw new EntityDuplicateException("Ingrese un código de refacción diferente");
        }
        return reRe.save(refaccion);
    }

    @Override
    public List<CatalogoRefaccion> crearMuchasRefacciones(List<CatalogoRefaccion> refacciones) {
        List<CatalogoRefaccion> ref = new ArrayList<>(limpiarLista(reRe.findAllByNumero(), refacciones));
        reRe.saveAll(ref);
        return ref;
    }

    @Override
    public List<CatalogoRefaccion> listaRefacciones() {
        return reRe.findAll();
    }

    @Override
    public CatalogoRefaccion traerRefaccion(String numero) {
        CatalogoRefaccion refaccion = this.existenciaRefaccion(numero);
        if(refaccion == null){throw new EntityNotFoundException("No se encontró la refacción");}
        //Ahora teniendo la refacción la regresamos.
        return refaccion;
    }

    @Override
    public List<CatalogoRefaccion> listStock() {
        return reRe.findByStockIsLessThan(5);
    }

    @Override
    public CatalogoRefaccion editarRefaccion(RefaccionUpdateDTO refaccionDTO) {
        CatalogoRefaccion refaccion = this.traerRefaccion(refaccionDTO.getNumero());
        if(refaccion == null){
            throw new EntityNotFoundException("Entidad no encontrada.");
        }
        //~~Ahora realizamos los cambios en la de los datos nuevos a los de la base de datos.
        refaccion = reUp.actualizarDatos(refaccion, refaccionDTO);

        return reRe.save(refaccion);
    }

    @Override
    public Map<String, String> eliminarPorNumero(String numero) {
        CatalogoRefaccion ref = this.existenciaRefaccion(numero);

        //Valida la existencia de una refacción.
        if(ref == null){
            throw new EntityNotFoundException("No se encontró refacción con ese numero.");
        }
        //Validación para no eliminar las refacciones con al menos un 1 en almacén.
        if(ref.getStock() > 0){
            throw new CantidadNoValidaException("Para eliminar un producto, este debe no tener cantidades almacenadas.");
        }
        //Ahora validamos si la refacción tiene algún detalle.
        DetalleOrden detalle = new DetalleOrden();

        long eliminado = reRe.deleteByNumero(numero);
        String mensaje = (eliminado == 1) ? "Eliminado." : "No eliminado" ;
        Map<String, String> mapa = new HashMap<>();
        mapa.put("Eliminar Refacción", ("Refacción con numero " + numero + ", " + mensaje ));

        return mapa;
    }


    @Override
    public CatalogoRefaccion existenciaRefaccion(String numero) {
        return reRe.findByNumero(numero);
    }

    //Funciones extras.
    public List<CatalogoRefaccion> limpiarLista(List<String>listaBD, List<CatalogoRefaccion>listNuevos ){
        List<CatalogoRefaccion> listaLimpia = new ArrayList<>();
        //Ahora en el mapa ponemos los datos de la lista obtenida de la base de datos.
        Map<String, String> mapa = listaBD.stream().collect(Collectors.toMap(
                x -> x,x -> x
        )) ;
        if(mapa.isEmpty()){
            //Si el mapa esta vacío entonces regresamos una lista vacía.
            log.warn("No hay datos en la base de datos.");
            return listNuevos;
        }
        //Ahora buscaremos y eliminaremos los duplicados.
        listNuevos.forEach(dato ->{
            if(mapa.get(dato.getNumero()) == null){
                listaLimpia.add(dato);
            }
        });
        return listaLimpia;
    }
}
