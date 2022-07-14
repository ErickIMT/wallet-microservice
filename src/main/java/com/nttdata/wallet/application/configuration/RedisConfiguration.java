package com.nttdata.wallet.application.configuration;

import com.nttdata.wallet.infrastructure.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

  @Bean
  public ReactiveRedisOperations<String, Customer> reactiveRedisOperations(ReactiveRedisConnectionFactory factory) {
    return new ReactiveRedisTemplate<String, Customer>(factory,
      RedisSerializationContext.fromSerializer(new Jackson2JsonRedisSerializer(Customer.class)));

    /*var serializer = new Jackson2JsonRedisSerializer<>(Customer.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, Customer> builder = RedisSerializationContext
      .newSerializationContext(new StringRedisSerializer());

    var serializationContext = builder.value(serializer).build();

    return new ReactiveRedisTemplate<>(factory, serializationContext);*/
  }
}
