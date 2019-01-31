package org._3rev.springclock.controller;

import org._3rev.springclock.gui.MainPanel;

public class Controller {

    private MainPanel clock;

    public void setClock(MainPanel clock) {
        this.clock = clock;
    }

    public void start() {
        clock.start(100);
    }

    public void stop() {
        clock.stop();
    }
}
