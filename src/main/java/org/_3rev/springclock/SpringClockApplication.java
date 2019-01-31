package org._3rev.springclock;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import processing.core.PApplet;

@SpringBootApplication
public class SpringClockApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringClockApplication.class)
                .headless(false)
                .run(args);
        PApplet.main("org._3rev.springclock.gui.MainPanel");
    }
}
