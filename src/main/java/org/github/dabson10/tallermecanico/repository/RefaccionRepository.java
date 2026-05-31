package org.github.dabson10.tallermecanico.repository;

import jakarta.transaction.Transactional;
import org.github.dabson10.tallermecanico.entity.CatalogoRefaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface RefaccionRepository extends JpaRepository<CatalogoRefaccion, Long> {
    @Query("SELECT numero FROM CatalogoRefaccion")
    List<String> findAllByNumero();

    List<CatalogoRefaccion> findByStockIsLessThan(Integer cantidad);

    //Busca una refacción por número.
    CatalogoRefaccion findByNumero(String numero);
    long deleteByNumero(String numero);
}
