package br.edu.infnet.dr1_tp3.service;

import br.edu.infnet.dr1_tp3.model.Aluno;
import br.edu.infnet.dr1_tp3.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}
