package br.edu.infnet.dr1_tp3.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @GetMapping("/config")
    public String getConfig() {
        return "Redis host: " + redisHost + ", Redis port: " + redisPort;
    }

    @PostMapping("/update-config")
    public String updateConfig(@RequestParam String host, @RequestParam int port) {
        System.setProperty("spring.redis.host", host);
        System.setProperty("spring.redis.port", String.valueOf(port));
        return "Configurações atualizadas: Redis host: " + host + ", Redis port: " + port;
    }
}
