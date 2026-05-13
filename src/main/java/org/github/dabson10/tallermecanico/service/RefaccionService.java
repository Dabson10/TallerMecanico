package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.github.dabson10.tallermecanico.exceptions.RefaccionDuplicateException;
import org.github.dabson10.tallermecanico.repository.RefaccionRepository;
import org.springframework.stereotype.Service;

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
            throw new RefaccionDuplicateException("Ingrese un código de refacción diferente");
        }
        return rePe.save(refaccion);
    }

    @Override
    public CatalogoRefaccion existenciaRefaccion(String numero) {
        return rePe.findByNumero(numero);
    }
}
