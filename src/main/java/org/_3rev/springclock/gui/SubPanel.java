package org._3rev.springclock.gui;

import processing.core.PApplet;

public abstract class SubPanel {

    protected final PApplet parent;
    protected final float x1;
    protected final float y1;
    protected final float x2;
    protected final float y2;

    protected final float width;
    protected final float height;

    protected final float centerX;
    protected final float centerY;

    protected final float top;
    protected final float bottom;
    protected final float left;
    protected final float right;


    public SubPanel(PApplet parent) {
        this(parent, 0, 0, parent.width, parent.height);
    }

    public SubPanel(PApplet parent, float x1, float y1, float x2, float y2) {
        this.parent = parent;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.width = x2 - x1;
        this.height = y2 - y1;

        this.centerX = (x1+x2)/2;
        this.centerY = (y1+y2)/2;

        this.top = y1;
        this.bottom = y2;
        this.left = x1;
        this.right = x2;
    }

    public abstract void setup();
}
