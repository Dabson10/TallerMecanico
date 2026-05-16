package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {

}
