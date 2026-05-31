package org.github.dabson10.tallermecanico.controller;

import jakarta.validation.Valid;
import org.github.dabson10.tallermecanico.dto.refaccionDTO.RefaccionUpdateDTO;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.github.dabson10.tallermecanico.service.RefaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/muchas")
    public ResponseEntity<List<CatalogoRefaccion>> crearRefaccion(
            @Valid @RequestBody List<CatalogoRefaccion> refaccion
    ){
        refaccion = reSe.crearMuchasRefacciones(refaccion);
        return new ResponseEntity<>(refaccion, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CatalogoRefaccion>> listaRefacciones(){
        List<CatalogoRefaccion> refaccion = reSe.listaRefacciones();
        return new ResponseEntity<>(refaccion, HttpStatus.OK);
    }

    @GetMapping("/{numero}/get")
    public ResponseEntity<CatalogoRefaccion> obtenerRefaccion(
            @Validated @PathVariable String numero
    ){
        CatalogoRefaccion refaccion = reSe.traerRefaccion(numero);
        return new ResponseEntity<>(refaccion, HttpStatus.OK);
    }

    @GetMapping("/list/stock")
    public ResponseEntity<List<CatalogoRefaccion>> refaccionPocasCantidades(){
        List<CatalogoRefaccion> list = reSe.listStock();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CatalogoRefaccion> actualizarDatos(
            @Valid @RequestBody RefaccionUpdateDTO refaccion
            ){
        CatalogoRefaccion ref = reSe.editarRefaccion(refaccion);
        return new ResponseEntity<>(ref, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, String>> eliminarRefaccion(
            @Validated @RequestParam(required = true, name = "numero") String numero
    ){
        Map<String, String> mapa = reSe.eliminarPorNumero(numero);
        return new ResponseEntity<>(mapa, HttpStatus.OK);
    }
}
