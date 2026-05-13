package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;

public interface RefaccionServiceImpl {
    CatalogoRefaccion crearRefaccion(CatalogoRefaccion refaccion);

    CatalogoRefaccion existenciaRefaccion(String numero);
}
