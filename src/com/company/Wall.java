package com.company;

import brickstate.GoldBrickState;

public class Wall {
    private Brick[][] bricks;

    public Wall(int row, int column) {
        bricks = new Brick[row][column];
        generateBricks(row, column);
    }

    public void generateBricks(int row, int column) {
        for(int i=0; i<row; i++){
            for(int j=0;j<column;j++){
                int brickWidth = 500/column;
                int brickHeight = 150/row;
                this.bricks[i][j] = new Brick(i, j, brickWidth, brickHeight, true);
                bricks[i][j].setState(new GoldBrickState());
            }
        }
    }

    public Brick[][] getBricksRows() {
        return bricks;
    }

    public Brick[] getBricksColumns() {
        return bricks[0];
    }
}
