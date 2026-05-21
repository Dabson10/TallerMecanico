package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.dto.tecnicoDTO.TecnicoCompletoOrdenesDTO;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Optional<Tecnico> findByCorreo(String correo);
}

