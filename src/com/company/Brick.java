package com.company;

import brickstate.BrickState;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class Brick {
    //    public int wall[][];
    private int brickRowIdentifier;
    private int brickColumnIdentifier;

    private int brickWidth;
    private int brickHeight;
    private boolean isVisible;
    private BrickState state;

    public Brick(int brickRowIdentifier, int brickColumnIdentifier, int brickWidth, int brickHeight, boolean isVisible) {
        this.brickRowIdentifier = brickRowIdentifier;
        this.brickColumnIdentifier = brickColumnIdentifier;
        this.brickHeight = brickHeight;
        this.brickWidth = brickWidth;
        this.isVisible = isVisible;
    }

    public BrickState getState() {
        return state;
    }

    public void setState(BrickState state) {
        this.state = state;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisibility(boolean visibility) {
        this.isVisible = visibility;
    }

    public int getBrickWidth() {
        return brickWidth;
    }

    public int getBrickHeight() {
        return brickHeight;
    }
}
