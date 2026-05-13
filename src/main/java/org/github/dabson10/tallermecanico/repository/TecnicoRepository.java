package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Tecnico findByCorreo(String correo);
}
