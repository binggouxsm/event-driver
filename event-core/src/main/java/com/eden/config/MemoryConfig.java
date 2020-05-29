package com.eden.config;

import com.eden.event.EventEngine;
import com.eden.event.impl.MemoryEventEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {
    @Bean
    public EventEngine memoryEngine(){
        return new MemoryEventEngine();
    }
}
