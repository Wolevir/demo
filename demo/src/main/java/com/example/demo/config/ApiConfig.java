package com.example.demo.config;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.*;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean(value = "method_call_count")
    public Counter methodCallCount() {
        return Metrics.counter("counter_hello");
    }
    @Bean("method_execution_timer")
    public Timer t() {
        return Metrics.timer("timer_hello");
    }
    @Bean("input_counter")
    public Counter inputCounter() {
        return Metrics.counter("service.inputSize", Tags.empty());
    }


}
