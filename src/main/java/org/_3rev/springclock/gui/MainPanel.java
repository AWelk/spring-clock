package org._3rev.springclock.gui;

import org._3rev.springclock.controller.Controller;
import org._3rev.springclock.gui.endmode.EndTimer;
import org.springframework.stereotype.Component;
import processing.core.PApplet;

@Component
public class MainPanel extends PApplet {

    public static Controller controller = new Controller();
    private EndTimer endTimer;

    public void settings() {
        size(800, 600);
//        fullScreen();
        controller.setClock(this);
    }

    public void setup() {
        frameRate(1);
        endTimer = new EndTimer(this);
        endTimer.setup();
    }

    public void draw() {
        background(0);
        endTimer.draw();
    }
}
