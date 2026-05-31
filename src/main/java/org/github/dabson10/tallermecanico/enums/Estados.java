package org.github.dabson10.tallermecanico.enums;

import lombok.Getter;
import org.github.dabson10.tallermecanico.exceptions.EstadoNotFoundException;

@Getter
public enum Estados {
    RECIBIDO(1, "Recibido."),
    EN_PROCESO(2, "En proceso."),
    LISTO(3, "Listo"),
    ENTREGADO(4, "Entregado");

    private  int numero;
    private String estado;

     Estados(int numero, String estado){
        this.numero = numero;
        this.estado = estado;
    }

    /**
     * Esta función es para buscar estados mediante un numero, no se si se usara.
     * @param numero : numero de búsqueda.
     * @return : Estado obtenido, o error.
     */
    public static Estados busquedaPorNumero(int numero){
         for(Estados estado : values()){
             if(estado.getNumero() == numero){
                 //Si son iguales entonces regresamos el valor
                 return estado;
             }
         }
         throw new EstadoNotFoundException("No se encontró el estado.");
    }

    /**
     * Función para buscar un estado por eso un estado con mejor vista.
     * @param estado : Carácter del estado.
     * @return : Regresará el estado o una excepción
     */
    public static Estados busquedaPorEstado(String estado){
         for(Estados estad : values()){
             if(estad.getEstado().equals(estado)){
                 return estad;
             }
         }
         throw new EstadoNotFoundException("No se encontró el estado.");
    }


}
