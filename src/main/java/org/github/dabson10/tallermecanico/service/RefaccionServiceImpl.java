package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;

import java.util.List;

public interface RefaccionServiceImpl {
    CatalogoRefaccion crearRefaccion(CatalogoRefaccion refaccion);
    List<CatalogoRefaccion> crearMuchasRefacciones(List<CatalogoRefaccion> refacciones);

    List<CatalogoRefaccion> listaRefacciones();

    //Traer una refacción mediante su numero.
    CatalogoRefaccion traerRefaccion(String numero);
    //Traer refacciones con un stock menor a 5
    List<CatalogoRefaccion> listStock();
    CatalogoRefaccion existenciaRefaccion(String numero);
}
