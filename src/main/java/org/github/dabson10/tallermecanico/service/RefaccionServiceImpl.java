package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;

import java.util.List;

public interface RefaccionServiceImpl {
    CatalogoRefaccion crearRefaccion(CatalogoRefaccion refaccion);
    List<CatalogoRefaccion> crearMuchasRefacciones(List<CatalogoRefaccion> refacciones);

    CatalogoRefaccion existenciaRefaccion(String numero);
}
