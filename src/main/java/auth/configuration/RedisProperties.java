package auth.configuration;

import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class RedisProperties {

    @Value("${spring.cluster.nodes}")
    private List<String> nodes;

    @Value("${spring.redis.password:#{null}}")
    private String password;

//    @Value("${spring.redis.port}")
//    private int port;

//    @Value("${spring.redis.database}")
//    private int database;

    @Value("${spring.redis.timeout}")
    private long timeout;

    @Value("${spring.redis.connections.max.total}")
    private int connectionsMaxTotal;

    @Value("${spring.redis.connections.max.idle}")
    private int connectionsMaxIdle;

    @Value("${spring.redis.connections.min.idle}")
    private int connectionsMinIdle;

}
