package org._3rev.springclock.config;

import org._3rev.springclock.controller.Controller;
import org._3rev.springclock.gui.MainPanel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Controller getController() {
        return MainPanel.controller;
    }
}
