package org._3rev.springclock.gui.endmode;

import org._3rev.springclock.gui.SubPanel;
import processing.core.PApplet;

public class EndTimer extends SubPanel {

    private ContinuousMode continuousMode;
    private FinalMode finalMode;

    private EndMode mode;

    public EndTimer(PApplet parent) {
        super(parent);
        mode = EndMode.CONTINUOUS;
    }

    public void setup() {
        continuousMode = new ContinuousMode(parent);
        continuousMode.setup();

        finalMode = new FinalMode(parent);
        finalMode.setup();
    }

    public void draw() {
        parent.background(0);

        if (EndMode.CONTINUOUS == mode) {
            continuousMode.draw();
        } else {
            finalMode.draw();
        }
    }

    public void continuousMode() {
        this.mode = EndMode.CONTINUOUS;
    }

    public void finalMode() {
        this.mode = EndMode.FINAL;
    }
}
