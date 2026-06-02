package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.dto.detalleOrdenDTO.DetalleSimpleDTO;
import org.github.dabson10.tallermecanico.entity.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleOrden, Long> {
    //Consulta para obtener una lista de detalles con base él, id de la Orden.
    @Query("SELECT d FROM DetalleOrden d WHERE d.ordenServicio.id_orden = :id")
    List<DetalleOrden> listarDetalles(@Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM DetalleOrden d WHERE d.refaccion.numero = :numero")
    Boolean existenciaDeRefaccionEnDetalles(@Param("numero") String numero);
}