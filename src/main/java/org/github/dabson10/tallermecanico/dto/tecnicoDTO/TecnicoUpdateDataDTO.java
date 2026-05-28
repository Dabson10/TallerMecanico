package org.github.dabson10.tallermecanico.dto.tecnicoDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TecnicoUpdateDataDTO {
    @NotBlank(message = "Ingrese el nombre nuevo del técnico.")
    private String nombreNuevo;
    @NotBlank(message = "Ingrese el correo del técnico.")
    @Email(message = "Ingrese un correo correcto nuevo.")
    private String correoNuevo;
    @NotBlank(message = "Ingrese el correo del técnico.")
    @Email(message = "Ingrese un corre electrónico valido.")
    private String correo;
}
