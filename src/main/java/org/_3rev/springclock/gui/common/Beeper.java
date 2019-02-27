package org._3rev.springclock.gui.common;

import processing.core.PApplet;
import processing.sound.SoundFile;

public class Beeper {

    private static SoundFile file;

    public Beeper(PApplet parent) {
        if (file == null) {
            file = new SoundFile(parent, "C:\\Users\\alexw\\Downloads\\beep-07.wav");
        }
    }

    public void beep() {
        if (!file.isPlaying()) {
            file.play();
        }
    }
}
