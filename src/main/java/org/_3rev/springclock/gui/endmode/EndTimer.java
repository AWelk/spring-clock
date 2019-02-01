package org._3rev.springclock.gui.endmode;

import org._3rev.springclock.gui.SubPanel;
import org._3rev.springclock.gui.common.Clock;
import processing.core.PApplet;

public class EndTimer extends SubPanel {

    private static final String DEFAULT_TIME = "01:23:45";

    private int totalSec = 30;
    private int duration = 30;
    private Clock clock;
    private ProgressBar bar;
    private EndMessage endMessage;

    public EndTimer(PApplet parent) {
        super(parent);
    }

    public void setup() {
        fitText(DEFAULT_TIME);

        clock = new Clock(parent, left, top, right, centerY);
        clock.setup();

        bar = new ProgressBar(parent, left, centerY, right, bottom, 8);
        bar.setup();

        endMessage = new EndMessage(parent);
        endMessage.setup();
    }

    public void draw() {
        parent.background(0);

        if (totalSec <= 0) {
            endMessage.draw();
        } else {
            clock.draw(totalSec);
            totalSec--;
            bar.draw(PApplet.map((duration-totalSec),0, duration, 0, 100));
        }
    }

//    private void fittedText(String message, float percentHeight) {
//        parent.textFont(font);
//        float size = PApplet.min(font.getSize() * parent.width / parent.textWidth(message), parent.height * percentHeight);
//        font = parent.createFont("Consolas-Bold-250", size);
//        parent.textSize(size);
//        parent.textFont(font);
//    }

//    private void displayEndMessage() {
//        fittedText("Curling!", 3);
//        parent.textAlign(parent.CENTER, parent.BOTTOM);
//        parent.text("Good", parent.width / 2f, parent.height / 2f);
//        parent.textAlign(parent.CENTER, parent.TOP);
//        parent.text("Curling!", parent.width / 2f, parent.height / 2f);
//    }

    public void start(int totalSec) {
        this.totalSec = totalSec;
        this.duration = totalSec;
    }
}
