package org._3rev.springclock.gui.endmode;

import org._3rev.springclock.gui.SubPanel;
import processing.core.PApplet;

import static org._3rev.springclock.gui.common.Constants.NUM_ENDS;

public class ContinuousMode extends SubPanel {

    private ContinuousTimer continuousTimer;
    private ProgressBar bar;

    private int progressBarSecond = 30;
    private int timerSeconds = progressBarSecond * (NUM_ENDS - 1) / NUM_ENDS;
    private int duration = 30;

    ContinuousMode(PApplet parent) {
        super(parent);
    }

    ContinuousMode(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    public void setup() {
        continuousTimer = new ContinuousTimer(parent, left, top, right, centerY);
        continuousTimer.setup();

        bar = new ProgressBar(parent, left, centerY, right, bottom, NUM_ENDS);
        bar.setup();
    }

    public void draw() {
        continuousTimer.draw(timerSeconds);
        timerSeconds--;
        bar.draw(PApplet.map((duration - progressBarSecond), 0, duration, 0, 100));
        progressBarSecond--;
    }
}
