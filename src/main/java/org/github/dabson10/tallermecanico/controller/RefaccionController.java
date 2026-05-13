package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.github.dabson10.tallermecanico.service.RefaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repair")
public class RefaccionController {
    //Inyección de dependencias.
    private final RefaccionService reSe;
    public RefaccionController(RefaccionService reSe){
        this.reSe = reSe;
    }

    @PostMapping("/create")
    public ResponseEntity<CatalogoRefaccion> crearRefaccion(
            @Valid @RequestBody CatalogoRefaccion refaccion
    ){
        refaccion = reSe.crearRefaccion(refaccion);
        return new ResponseEntity<>(refaccion, HttpStatus.CREATED);
    }
}
