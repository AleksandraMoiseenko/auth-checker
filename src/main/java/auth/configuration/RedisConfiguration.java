package auth.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfiguration {

    @Primary
    @Bean("lettuceConnectionFactory")
    public RedisConnectionFactory lettuceConnectionFactory(RedisProperties properties) {
        var clusterConfiguration = new RedisClusterConfiguration(properties.getNodes());
        clusterConfiguration.setMaxRedirects(2);

        return new LettuceConnectionFactory(clusterConfiguration);
    }

    @Primary
    @Bean("configuredRedisTemplate")
    public StringRedisTemplate redisTemplate(@Qualifier("lettuceConnectionFactory") RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
