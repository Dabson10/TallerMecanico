package org.github.dabson10.tallermecanico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Entity
@Getter @Setter
@AllArgsConstructor
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id_orden;
    @NotBlank(message = "Ingrese un problema.")
    private String problema;
    private LocalDate fecha_registro;
    @Enumerated(EnumType.STRING)
    private Estados estado;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @OneToMany(mappedBy = "ordenServicio")
    private List<DetalleOrden> detalles;

    public OrdenServicio(){}

    @PrePersist
    public void newOrden(){
        log.info("Se intentara guardar la orden a nombre de: {}.| fecha {}",cliente.getNombre(), fecha_registro);
    }

    @PostPersist
    public void ordenCreada(){
        log.info("Se creo la orden a nombre de: {}", cliente.getNombre());
    }

}
