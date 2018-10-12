package com.company;

public class Spacecraft {
    public int spacecraftX;

    public Spacecraft(int x){
        super();
        this.spacecraftX = x;
    }

    public int getSpacecraftX() {
        return spacecraftX;
    }

    public void setSpacecraftX(int spacecraftX) {
        this.spacecraftX = spacecraftX;
    }

    public void addSpacecraftX(int x){
        this.spacecraftX += x;
    }
}
