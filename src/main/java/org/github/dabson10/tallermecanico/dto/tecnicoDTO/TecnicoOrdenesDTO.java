package org.github.dabson10.tallermecanico.dto.tecnicoDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioHistorialDTO;

import java.util.List;

@Getter @Setter
public class TecnicoOrdenesDTO {
    private Long id_tecnico;
    @NotBlank(message = "Ingrese el nombre del técnico.")
    private String nombre;
    @NotBlank(message = "Ingrese el correo del técnico.")
    @Email(message = "Ingrese un correo correcto.")
    private String correo;
    private List<OrdenServicioHistorialDTO> ordenes;

}
