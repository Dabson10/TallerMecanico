package org.github.dabson10.tallermecanico.utility.actualizarDatos;

import org.github.dabson10.tallermecanico.dto.refaccionDTO.RefaccionUpdateDTO;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.github.dabson10.tallermecanico.enums.CambioStock;
import org.springframework.stereotype.Component;

@Component
public class RefaccionDatosUpdate {
    public CatalogoRefaccion actualizarDatos(
            CatalogoRefaccion refaccion, RefaccionUpdateDTO refaccionDTO){
        /*
        El proceso para guardar los datos es. Si los valores son diferentes los guardamos.
        En el caso de stock o cantidad sumamos.
         */
        if(!refaccionDTO.getNombreNuevo().equals(refaccion.getNombre()) && !refaccionDTO.getNombreNuevo().isBlank()){
            //Si el nombre es diferente al de base de datos y no es una cadena con espacios en blanco. Entonces guardamos.
            refaccion.setNombre(refaccionDTO.getNombreNuevo());
        }
        //-Valida precios.
        float precioDB = refaccion.getPrecioActual(); float precioNuevo = refaccionDTO.getPrecioNuevo();
        if(precioDB != precioNuevo){
            //Si los precios son diferentes entonces guardamos el valor nuevo.
            refaccion.setPrecioActual(precioNuevo);
        }
        //Validación para las cantidades en stock.
        int stockNew = refaccionDTO.getStockCambio();
        //*Primero validamos que el estado del enum sea diferente a NINGUNO y la cantidad nueva sea mayor a 0.
        if(refaccionDTO.getCambiosStock() != CambioStock.NINGUNO && stockNew > 0 ){
            //-Esta validación con switch es para saber que operación se realizara.
            switch (refaccionDTO.getCambiosStock()){
                //! Si el valor es AUMENTAR entonces se aumentara en (n) la cantidad del stock
                case AUMENTAR ->
                        refaccion.setStock( refaccion.getStock() + refaccionDTO.getStockCambio() );

                //~~Si el valor es DISMINUIR entonces usaremos una resta para restar del stock.
                case DISMINUIR ->
                        refaccion.setStock( refaccion.getStock() - refaccionDTO.getStockCambio() );
            }
        }

        return refaccion;
    }
}
