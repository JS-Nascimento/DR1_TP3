package br.edu.infnet.dr1_tp3.service;

import br.edu.infnet.dr1_tp3.model.Curso;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Data
public class CursoCacheService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CursoCacheService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

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

