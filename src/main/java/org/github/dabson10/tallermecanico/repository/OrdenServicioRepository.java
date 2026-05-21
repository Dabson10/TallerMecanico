package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.dto.ordenServicioDTO.OrdenServicioHistorialDTO;
import org.github.dabson10.tallermecanico.entity.Estados;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {
     List<OrdenServicioHistorialDTO> findByTecnico_CorreoAndEstadoIsNot(String tecnico_correo, Estados estado);
}
