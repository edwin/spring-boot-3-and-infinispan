package com.edw.config;

import org.infinispan.client.hotrod.configuration.ClientIntelligence;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.transport.tcp.RoundRobinBalancingStrategy;
import org.infinispan.commons.marshall.JavaSerializationMarshaller;
import org.infinispan.spring.starter.remote.InfinispanRemoteCacheCustomizer;
import org.infinispan.spring.starter.remote.InfinispanRemoteConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * <pre>
 *     com.edw.config.InfinispanConfiguration
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 27 Apr 2023 11:59
 */
@Configuration
public class InfinispanConfiguration {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public InfinispanRemoteCacheCustomizer remoteCacheCustomizer() {
        return b -> {
            b.remoteCache("user-cache").marshaller(JavaSerializationMarshaller.class);
        };
    }
}
