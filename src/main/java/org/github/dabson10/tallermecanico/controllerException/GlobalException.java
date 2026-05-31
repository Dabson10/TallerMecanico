package org.github.dabson10.tallermecanico.controllerException;

import jakarta.validation.ConstraintViolationException;
import org.github.dabson10.tallermecanico.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        ex.getBindingResult().getFieldErrors().forEach(p -> error.put(p.getField(), p.getDefaultMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> errorSecundarioEntity(
            ConstraintViolationException ex
    ){
        Map<String, String> error = new HashMap<>();
        ex.getConstraintViolations().forEach(viol ->{
            String clase = viol.getPropertyPath().toString();
            String mensaje = viol.getMessage();
            error.put(clase, mensaje);
        });
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Captura la excepción de correo duplicado.
     * @param ex : Excepción capturada.
     * @return : Regresará un JSON con el valor del error.
     */
    @ExceptionHandler(CorreoDuplicateException.class)
    public ResponseEntity<Map<String, String>> correoDuplicado(
            CorreoDuplicateException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(ClienteConVehiculoException.class)
    public ResponseEntity<Map<String, String>> clienteConVehiculo(
            ClienteConVehiculoException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(ListaVaciaException.class)
    public ResponseEntity<Map<String, String>> tecnicoSinOrdenes(
            ListaVaciaException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> entidadNoEncontrada(
            EntityNotFoundException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityDuplicateException.class)
    public ResponseEntity<Map<String, String>> entidadesDuplicadas(
            EntityDuplicateException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CantidadNoValidaException.class)
    public ResponseEntity<Map<String, String>> sinCantidades(CantidadNoValidaException ex){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, String>> valorNull(
            NullPointerException ex
    ){
        Map<String, String> error = new HashMap<>();
        error.put(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
