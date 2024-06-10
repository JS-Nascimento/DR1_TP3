package br.edu.infnet.dr1_tp3.repository;

import br.edu.infnet.dr1_tp3.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}