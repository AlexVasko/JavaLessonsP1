package com.javalesson.nestedclasses;

import java.util.ArrayList;
import java.util.List;

public class Display {

    private int displayHeight;
    private int displayWidth;
    private List<Pixel> pixels = new ArrayList<>();

    public Display(int displayHeight, int displayWidth) {
        this.displayHeight = displayHeight;
        this.displayWidth = displayWidth;
    }

    public void drawPixel(){
        pixels.add(new Pixel(123,456, "RED"));
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayHeight(int displayHeight) {
        this.displayHeight = displayHeight;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(int displayWidth) {
        this.displayWidth = displayWidth;
    }

    public static class Pixel {
        private int x;
        private int y;
        private String colour;

        public Pixel(int x, int y, String colour) {
            if (x > 0 && x < 1280 && y > 0 && y < 1920) {
                this.x = x;
                this.y = y;
            } else {
                throw new IllegalArgumentException("Pixel coordinates are out of screen");
            }
            this.colour = colour;
            System.out.println("Creating pixel of " + colour + " colour at (" + x + "," + y + ")");
        }
    }
}
