package org.github.dabson10.tallermecanico.dto.ordenServicioDTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.tallermecanico.enums.Estados;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class OrdenServicioSimpleDTO {
    private Long id_orden;
    @NotBlank(message = "Ingrese un problema.")
    private String problema;
    private LocalDate fecha_registro;
    @Enumerated(EnumType.STRING)
    private Estados estado;
}
