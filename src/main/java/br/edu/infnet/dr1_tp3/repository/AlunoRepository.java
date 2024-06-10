package br.edu.infnet.dr1_tp3.repository;

import br.edu.infnet.dr1_tp3.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}