package br.edu.infnet.dr1_tp3.service;

import br.edu.infnet.dr1_tp3.model.Curso;
import br.edu.infnet.dr1_tp3.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}
