package com.akul.microservices.notification.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

/**
 * ObservabilityConfig.java.
 *
 * @author Andrii Kulynych
 * @since 11/16/2025
 */
@Configuration
@RequiredArgsConstructor
public class ObservabilityConfig {

    private final ConcurrentKafkaListenerContainerFactory<String, String> kafkaFactory;

    @EventListener(ApplicationReadyEvent.class)
    public void enableKafkaObservation() {
        kafkaFactory
                .getContainerProperties()
                .setObservationEnabled(true);
    }

    @Bean
    ObservedAspect observedAspect(ObservationRegistry registry) {
        return new ObservedAspect(registry);
    }
}
