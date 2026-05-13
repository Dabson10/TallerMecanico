package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    //Función para buscar mediante las placas.
    Vehiculo findByPlacas(String placas);
}
