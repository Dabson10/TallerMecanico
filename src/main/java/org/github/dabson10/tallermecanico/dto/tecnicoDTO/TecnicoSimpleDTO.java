package org.github.dabson10.tallermecanico.dto.tecnicoDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoSimpleDTO {
    private Long id_tecnico;
    @NotBlank(message = "Ingrese el nombre del técnico.")
    private String nombre;
    @NotBlank(message = "Ingrese el correo del técnico.")
    @Email(message = "Ingrese un correo correcto.")
    private String correo;
}
