package org.github.dabson10.tallermecanico.dto.clienteDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSimpleDTO {
    private Long id_cliente;
    @NotBlank(message = "Ingrese su nombre.")
    private String nombre;
    @NotBlank(message = "Ingrese su apellido.")
    private String apellido;
    @NotBlank(message = "Ingrese su numero de teléfono.")
    private String telefono;
    @NotBlank(message = "Ingrese el correo del cliente")
    private String correo;
}
