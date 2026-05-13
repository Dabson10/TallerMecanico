package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCorreo(String correo);
}
