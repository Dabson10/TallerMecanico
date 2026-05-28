package org.github.dabson10.tallermecanico.dto.clienteDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ClienteUpdateDTO {
    private Long id_cliente;
    @NotBlank(message = "Ingrese un nombre")
    private String nombreNuevo;
    @NotBlank(message = "Ingrese un apellido")
    private String apellidoNuevo;
    @NotBlank(message = "Ingrese un teléfono")
    private String telefonoNuevo;
    @NotBlank(message = "Ingrese un correo nuevo.")
    private String correoNuevo;
    @NotBlank(message = "Ingrese el correo del cliente")
    private String correo;
}

