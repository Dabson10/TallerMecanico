package org.github.dabson10.tallermecanico.service;

import org.github.dabson10.tallermecanico.dto.refaccionDTO.RefaccionUpdateDTO;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;

import java.util.List;
import java.util.Map;

public interface RefaccionServiceImpl {
    CatalogoRefaccion crearRefaccion(CatalogoRefaccion refaccion);
    List<CatalogoRefaccion> crearMuchasRefacciones(List<CatalogoRefaccion> refacciones);

    List<CatalogoRefaccion> listaRefacciones();

    //Traer una refacción mediante su numero.
    CatalogoRefaccion traerRefaccion(String numero);
    //Traer refacciones con un stock menor a 5
    List<CatalogoRefaccion> listStock();
    //Editar datos de una refacción
    CatalogoRefaccion editarRefaccion(RefaccionUpdateDTO refaccionDTO);
    //Elimina una refacción por su nombre.
    Map<String, String> eliminarPorNumero(String numero);
    //Valida la existencia de una refaccion.
    CatalogoRefaccion existenciaRefaccion(String numero);
}
