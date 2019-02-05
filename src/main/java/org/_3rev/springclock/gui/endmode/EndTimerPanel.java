package org._3rev.springclock.gui.endmode;

import org._3rev.springclock.gui.SubPanel;
import processing.core.PApplet;

public class EndTimerPanel extends SubPanel {

    private ContinuousMode continuousMode;
    private FinalMode finalMode;

    private TimerMode activeMode;

    public EndTimerPanel(PApplet parent) {
        super(parent);
    }

    public void setup() {
        continuousMode = new ContinuousMode(parent);
        continuousMode.setup();
        activeMode = continuousMode;

        finalMode = new FinalMode(parent);
        finalMode.setup();
    }

    public void draw() {
        activeMode.draw();
    }

    private void start(int totalSeconds) {
        activeMode.setTime(totalSeconds);
    }

    public void continuousMode(int totalSeconds) {
        activeMode = continuousMode;
        start(totalSeconds);
    }

    public void finalMode(int totalSeconds) {
        activeMode = finalMode;
        start(totalSeconds);
    }
}
