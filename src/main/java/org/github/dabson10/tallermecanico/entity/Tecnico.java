package org.github.dabson10.tallermecanico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id_tecnico;
    @NotBlank(message = "Ingrese un nombre de técnico.")
    private String nombre;
    @NotBlank(message = "Ingrese un correo.")
    @Email(message = "Ingrese un correo valido.")
    private String correo;
    @NotNull(message = "Ingrese un estado del técnico.")
    private Boolean activo;
    @OneToMany(mappedBy = "tecnico")
    private List<OrdenServicio> ordenes;

    public Boolean cambioEstado(){
        return !activo;
    }
    @PrePersist
    public void newTecnico(){
        this.activo = true;
        log.info("Se intentara crear un nuevo técnico llamado: {}", nombre);
    }

    @PostPersist
    public void tecnicoCreado(){
        log.info("Se creo el técnico llamado: {}", nombre);
    }

}
