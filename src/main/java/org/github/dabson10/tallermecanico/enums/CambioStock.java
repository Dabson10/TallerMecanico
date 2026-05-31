package org.github.dabson10.tallermecanico.enums;

import lombok.Getter;
import org.github.dabson10.tallermecanico.exceptions.EntityNotFoundException;

@Getter
public enum CambioStock {
    NINGUNO ("Ninguno"),
    AUMENTAR ("Aumentar"),
    DISMINUIR("Disminuir");

    private final String valor;

    CambioStock(String valor){
        this.valor = valor;
    }

    //Busca el valor mediante su valor secundario.
    public static CambioStock buscarPorValor(String valor){
        for(CambioStock dato : values()){
            if(dato.getValor().equals(valor)){
                return dato;
            }
        }
        throw new EntityNotFoundException("No se encontró un estado con ese valor.");
    }

}
