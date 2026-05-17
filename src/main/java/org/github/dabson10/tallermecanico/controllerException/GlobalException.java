package org.github.dabson10.tallermecanico.controllerException;

import org.github.dabson10.tallermecanico.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {


    /**
     * Esta función captará todos los atributos que no fueron llenados, solo
     * si se utiliza la annotation @Valid o @Validate, esto en los controladores.
     * @param ex : Este es el error que se capturó.
     * @return : Regresara un JSON con los valores o atributos faltantes.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> valoresVacios(
            MethodArgumentNotValidException ex
    ){
        Map<String, String> error = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(p -> {
            error.put(p.getField(), p.getDefaultMessage());
        });
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Captura la excepción de correo duplicado.
     * @param ex : Excepción capturada.
     * @return : Regresara un JSON con el valor del error.
     */
    @ExceptionHandler(CorreoDuplicateException.class)
    public ResponseEntity<Map<String, String>> correoDuplicado(
            CorreoDuplicateException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(VehiculoDuplicateException.class)
    public ResponseEntity<Map<String, String>> vehiculoDuplicado(
            VehiculoDuplicateException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<Map<String, String>> clienteNoEncontrado(
            ClienteNotFoundException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TecnicoNotFoundException.class)
    public ResponseEntity<Map<String, String>> tecnicoNoEncontrado(
            TecnicoNotFoundException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(VehiculoNotFoundException.class)
    public ResponseEntity<Map<String, String>> vehiculoNoEncontrado(VehiculoNotFoundException ex){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }



}
