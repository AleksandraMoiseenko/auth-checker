package auth.controller;

import auth.repository.RedisRepository;
import auth.repository.impl.RedisSuffixes;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
