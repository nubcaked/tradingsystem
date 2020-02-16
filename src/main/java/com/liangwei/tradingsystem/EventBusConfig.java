package com.liangwei.tradingsystem;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class EventBusConfig {
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
