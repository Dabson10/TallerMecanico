package org.github.dabson10.tallermecanico.dto.clienteDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSimpleDTO {
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
}
