package br.edu.infnet.dr1_tp3.controller;

import br.edu.infnet.dr1_tp3.model.Curso;
import br.edu.infnet.dr1_tp3.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @Cacheable("cursos")
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.findById(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            Curso updatedCurso = curso.get();
            updatedCurso.setNome(cursoDetails.getNome());
            updatedCurso.setAlunos(cursoDetails.getAlunos());
            cursoService.save(updatedCurso);
            return ResponseEntity.ok(updatedCurso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "cursos", allEntries = true)
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        if (cursoService.findById(id).isPresent()) {
            cursoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}