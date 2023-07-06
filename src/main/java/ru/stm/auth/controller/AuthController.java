package ru.stm.auth.controller;

import ru.stm.auth.repository.RedisRepository;
import ru.stm.auth.repository.impl.RedisSuffixes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final RedisRepository redisRepository;

    @PostMapping("/token")
    public String getToken(@RequestBody String token) {
        System.out.println(token + RedisSuffixes.token.getSuffix());
        return redisRepository.getString(token + RedisSuffixes.token.getSuffix());
    }
}
