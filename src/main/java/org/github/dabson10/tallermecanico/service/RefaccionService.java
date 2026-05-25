package org.github.dabson10.tallermecanico.service;

import lombok.extern.slf4j.Slf4j;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.github.dabson10.tallermecanico.exceptions.EntityDuplicateException;
import org.github.dabson10.tallermecanico.exceptions.EntityNotFoundException;
import org.github.dabson10.tallermecanico.repository.RefaccionRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RefaccionService implements RefaccionServiceImpl{
    //Inyección de dependencias.
    private final RefaccionRepository rePe;
    public RefaccionService(RefaccionRepository rePe){
        this.rePe = rePe;
    }

    @Override
    public CatalogoRefaccion crearRefaccion(CatalogoRefaccion refaccion) {
        CatalogoRefaccion ref = this.existenciaRefaccion(refaccion.getNumero());
        if(ref != null){
            //Si existe la refacción mostramos una exception.
            throw new EntityDuplicateException("Ingrese un código de refacción diferente");
        }
        return rePe.save(refaccion);
    }

    @Override
    public List<CatalogoRefaccion> crearMuchasRefacciones(List<CatalogoRefaccion> refacciones) {
        List<CatalogoRefaccion> ref = new ArrayList<>(limpiarLista(rePe.findAllByNumero(), refacciones));
        rePe.saveAll(ref);
        return ref;
    }

    @Override
    public List<CatalogoRefaccion> listaRefacciones() {
        return rePe.findAll();
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
        return rePe.findByStockIsLessThan(5);
    }

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



    @Override
    public CatalogoRefaccion existenciaRefaccion(String numero) {
        return rePe.findByNumero(numero);
    }
}
