package org._3rev.springclock.gui.common;

import org._3rev.springclock.gui.SubPanel;
import processing.core.PApplet;

public class Clock extends SubPanel {

    public Clock(PApplet parent) {
        super(parent);
    }

    public Clock(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    public void setup() {
        parent.textAlign(PApplet.CENTER, PApplet.BOTTOM);
        fitText("00:11:22", x1, y1, x2, y2);
    }

    public void draw() {
        writeTime();
    }

    public void draw(int totalSec) {
        int seconds = totalSec % 60;
        int totalMinutes = totalSec / 60;
        int minutes = totalMinutes % 60;
        int hours = totalMinutes / 60;

        String time = PApplet.nf(hours, 2) + ":" + PApplet.nf(minutes, 2) + ":" + PApplet.nf(seconds, 2);

        parent.textAlign(PApplet.CENTER, PApplet.BOTTOM);
        parent.fill(255, 0, 0);

        text(time, centerX, bottom);
//        fittedText(PApplet.nf(hours, 2) + ":" + PApplet.nf(minutes, 2) + ":" + PApplet.nf(seconds, 2), x1, y1, x2, y2);
    }

    private void writeTime() {
        parent.fill(255, 0, 0);
        parent.text(PApplet.nf(PApplet.hour()%12, 2) + ":" + PApplet.nf(PApplet.minute(), 2), centerX, bottom);
    }
}
