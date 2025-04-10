/ RedisConfig.java
package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.ConnectionPoolConfig;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Value("${memorydb.endpoint}")
    private String memoryDbEndpoint;

    @Value("${memorydb.port}")
    private int memoryDbPort;

    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort(memoryDbEndpoint, memoryDbPort));

        ConnectionPoolConfig poolConfig = new ConnectionPoolConfig();
        poolConfig.setMaxTotal(32);
        poolConfig.setMaxIdle(16);

        return new JedisCluster(nodes, 2000, 2000, 5, poolConfig);
    }
}

