package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefaccionRepository extends JpaRepository<CatalogoRefaccion, Long> {
    @Query("SELECT numero FROM CatalogoRefaccion")
    List<String> findAllByNumero();

    CatalogoRefaccion findByNumero(String numero);
}
