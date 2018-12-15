package com.company;

import state.GameState;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameRules {

    private GameState gameState;

    public GameRules(GameState gameState) {
        this.gameState = gameState;
    }

    public void actionPerformed(ActionEvent e) {
        if(gameState.isPlaying()) {
            checkSpacecraftBallIntersection();

            gameState.getBall().setBallX(gameState.getBall().getBallDirectionX());
            gameState.getBall().setBallY(gameState.getBall().getBallDirectionY());

            if(gameState.getBall().getBallX() <10) {
                gameState.getBall().setBallDirectionXToOpposite();
            }
            if(gameState.getBall().getBallY() <10) {
                gameState.getBall().setBallDirectionYToOpposite();
            }
            if(gameState.getBall().getBallX() > 570) {
                gameState.getBall().setBallDirectionXToOpposite();
            }
            if(gameState.getBall().getBallY() > 670) {
                gameState.setPlaying(false);
            }

            for(int i = 0; i< gameState.getWall().getBricksRows().length; i++){
                Brick[] brickRow = gameState.getWall().getBricksRows()[0];
                for(int j = 0; j< brickRow.length; j++){
                    Brick brick = gameState.getWall().getBricksRows()[i][j];
                    if(brick.isVisible()) {
                        checkBallBrickIntersection(i,j);
                    }
                }
            }

        }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
            if(gameState.getSpacecraft().getSpacecraftX() >= 490){
                gameState.getSpacecraft().setSpacecraftX(490);
            }
            else{
                this.moveRight();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT) {
            if(gameState.getSpacecraft().getSpacecraftX() <= 20) {
                gameState.getSpacecraft().setSpacecraftX(20);
            } else {
                this.moveLeft();
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void moveLeft() {
        gameState.setPlaying(true);
        gameState.getSpacecraft().addSpacecraftX(-10);
    }

    public void moveRight() {
        gameState.setPlaying(true);
        gameState.getSpacecraft().addSpacecraftX(10);
    }

    public void checkSpacecraftBallIntersection() {
        Rectangle ballRect = new Rectangle(gameState.getBall().getBallX(), gameState.getBall().getBallY(), 20, 20);
        Rectangle spacecraftRect = new Rectangle(gameState.getSpacecraft().getSpacecraftX(), 550, 100, 10);

        if(ballRect.intersects(spacecraftRect)) {
            gameState.getBall().setBallDirectionYToOpposite();
        }
    }

    public void checkBallBrickIntersection(int rowId, int columnId) {
        int brickWidth = gameState.getWall().getBricksRows()[0][0].getBrickWidth();
        int brickHeight = gameState.getWall().getBricksRows()[0][0].getBrickHeight();
        Rectangle brick = new Rectangle(columnId* brickWidth+50, rowId* brickHeight+50, brickWidth, brickHeight);
        Rectangle ballRect = new Rectangle(gameState.getBall().getBallX(), gameState.getBall().getBallY(), 20,20);
        if(ballRect.intersects(brick)){
            gameState.getWall().getBricksRows()[rowId][columnId].setVisibility(false);
            // gameState.getBrick().wall[rowId][columnId] = 0;
            gameState.getBall().setBallDirectionXToOpposite();
            gameState.getBall().setBallDirectionYToOpposite();
        }
    }

}
