package br.edu.infnet.dr1_tp3.service;

import br.edu.infnet.dr1_tp3.model.MaterialDidatico;
import br.edu.infnet.dr1_tp3.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    public MaterialDidatico save(MaterialDidatico material) {
        return materialDidaticoRepository.save(material);
    }

    public List<MaterialDidatico> findAll() {
        return materialDidaticoRepository.findAll();
    }

    public Optional<MaterialDidatico> findById(String id) {
        return materialDidaticoRepository.findById(id);
    }

    public void deleteById(String id) {
        materialDidaticoRepository.deleteById(id);
    }
}
