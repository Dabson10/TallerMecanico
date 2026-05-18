package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleOrden, Long> {
}
