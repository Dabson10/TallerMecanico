package org.github.dabson10.tallermecanico.repository;

import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefaccionRepository extends JpaRepository<CatalogoRefaccion, Long> {
    CatalogoRefaccion findByNumero(String numero);
}
