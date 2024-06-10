package br.edu.infnet.dr1_tp3.service;

import br.edu.infnet.dr1_tp3.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CursoCacheService {
    @Autowired
    private RedisTemplate<String, Curso> redisTemplate;

    private static final String KEY = "Curso";

    public void save(Curso curso) {
        redisTemplate.opsForHash().put(KEY, curso.getId().toString(), curso);
    }

    public Curso findById(Long id) {
        return (Curso) redisTemplate.opsForHash().get(KEY, id.toString());
    }

    public void deleteById(Long id) {
        redisTemplate.opsForHash().delete(KEY, id.toString());
    }
}

