package com.company;

import brickstate.GoldBrickState;
import brickstate.RedBrickState;
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
                gameState.getBall().setBallDirectionYToOpposite();
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
            if(ballRect.getX() > spacecraftRect.getCenterX()) {
                gameState.getBall().setBallDirectionX(1);
            } else {
                gameState.getBall().setBallDirectionX(-1);
            }
        }
    }

    public void checkBallBrickIntersection(int rowId, int columnId) {
        int brickWidth = gameState.getWall().getBricksRows()[0][0].getBrickWidth();
        int brickHeight = gameState.getWall().getBricksRows()[0][0].getBrickHeight();
        Rectangle brick = new Rectangle(columnId* brickWidth+50, rowId* brickHeight+50, brickWidth, brickHeight);

        Rectangle ballRect = new Rectangle(gameState.getBall().getBallX(), gameState.getBall().getBallY(), 20,20);

        if(ballRect.intersects(brick)){
            gameState.getBall().setBallDirectionYToOpposite();
            Brick currentBrick = gameState.getWall().getBricksRows()[rowId][columnId];
            currentBrick.getState().changeLifePoints(currentBrick);
            gameState.getBall().setBallDirectionXToOpposite();
        }
    }

}
