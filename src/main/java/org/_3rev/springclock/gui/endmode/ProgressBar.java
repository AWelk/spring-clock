package org._3rev.springclock.gui.endmode;

import org._3rev.springclock.gui.SubPanel;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class ProgressBar extends SubPanel {

    private int numEnds;

    private List<EndBlock> blocks;

    ProgressBar(PApplet parent, float x1, float y1, float x2, float y2, int numEnds) {
        super(parent, x1, y1, x2, y2);
        this.numEnds = numEnds;
    }

    public void setup() {
        initBlocks();

    }

    public void draw(float percentComplete) {
        for (EndBlock block : blocks) {
            block.draw(percentComplete);
        }
    }

    private void initBlocks() {
        float blockRadius = width/numEnds;
        float blockTop = centerY-(blockRadius/2);
        float blockBottom = centerY+(blockRadius/2);
        float blockLeft = left;
        blocks = new ArrayList<>(numEnds);
        while(blockLeft < right) {
            EndBlock block = new EndBlock(parent, blockLeft, blockTop, blockLeft+blockRadius, blockBottom);
            block.setup();
            blocks.add(block);
            blockLeft+=blockRadius;
        }
    }

    public void setNumEnds(int numEnds) {
        this.numEnds = numEnds;
    }


}
