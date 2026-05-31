package org.github.dabson10.tallermecanico.repository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.github.dabson10.tallermecanico.enums.Estados;
import org.github.dabson10.tallermecanico.entity.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {
     //Consulta para traer las órdenes del cliente mediante su correo
     List<OrdenServicio> findOrdenServicioByCliente_Correo(String correo);
     List<OrdenServicio> findOrdenServicioByTecnico_CorreoAndEstadoNot(@NotBlank(message = "Ingrese un correo.") @Email(message = "Ingrese un correo valido.") String tecnico_correo, Estados estado);
     List<OrdenServicio> findOrdenServicioByEstado(Estados estado);

}
