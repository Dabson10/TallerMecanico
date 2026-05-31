package org.github.dabson10.tallermecanico.dto.refaccionDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.github.dabson10.tallermecanico.enums.CambioStock;

@Getter @Setter
public class RefaccionUpdateDTO {
    @NotBlank(message = "Ingrese el numero de la refacción")
    private String numero;
    @NotBlank(message = "Ingrese un nombre nuevo.")
    private String nombreNuevo;
    @NotNull(message = "Ingrese un precio.")
    @Min(value = 1, message = "Ingrese cantidades validas.")
    private Integer stockCambio;
    @NotNull(message = "Ingrese un precio valido.")
    @Positive(message = "Ingrese un valor positivo.")
    private Float precioNuevo;
    private CambioStock cambiosStock;
}
