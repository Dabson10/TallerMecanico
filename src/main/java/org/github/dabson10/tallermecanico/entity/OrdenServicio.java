package org.github.dabson10.tallermecanico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id_orden;
    @NotBlank(message = "Ingrese un problema.")
    private String problema;
    private LocalDate fecha_registro = LocalDate.now();
    @NotBlank(message = "Ingrese un estado.")
    private String estado;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @OneToMany(mappedBy = "ordenServicio")
    private List<DetalleOrden> detalles;
}
