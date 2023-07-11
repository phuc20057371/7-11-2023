package com.example.demo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.example.demo.entity.Khoahoc;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Khoahoc> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Khoahoc> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Khoahoc.class));
        return redisTemplate;
    }
}
