package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    //Función para buscar mediante las placas.
    Optional<Vehiculo> findByPlacas(String placas);
}
