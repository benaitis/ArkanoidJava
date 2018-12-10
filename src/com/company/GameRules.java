package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameRules implements KeyListener, ActionListener {

    private boolean gameState;
    private Spacecraft spacecraft;
    private Ball ball;
    private Wall wall;
    private GameRender gameRender;
    private Timer timer;
    private int delay = 4;

    public GameRules(Spacecraft spacecraft, Ball ball, Wall wall, GameRender gameRender) {
        this.spacecraft = spacecraft;
        this.gameState = false;
        this.ball = ball;
        this.spacecraft = spacecraft;
        this.wall = wall;
        this.gameRender = gameRender;
        gameRender.addKeyListener(this);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.getGameState()) {
            Rectangle ballrect = new Rectangle(ball.getBallX(), ball.getBallY(), 20, 20);
            Rectangle spacecraftRect = new Rectangle(spacecraft.getSpacecraftX(), 550, 100, 10);
            if(ballrect.intersects(spacecraftRect)) {
                ball.setBallDirectionYToOpposite();
            }

            ball.setBallX(ball.getBallDirectionX());
            ball.setBallY(ball.getBallDirectionY());

            if(ball.getBallX() <10) {
                ball.setBallDirectionXToOpposite();
            }
            if(ball.getBallY() <10) {
                ball.setBallDirectionYToOpposite();
            }
            if(ball.getBallX() > 570) {
                ball.setBallDirectionXToOpposite();
            }
            if(ball.getBallY() > 670) {
                this.setGameState(false);
            }

            for(int i=0;i<wall.wall.length;i++){
                for(int j=0;j<wall.wall[0].length;j++){
                    if(wall.wall[i][j] != 0) {
                        Rectangle brick = new Rectangle(j*wall.brickWidth+50, i*wall.brickHeight+50, wall.brickWidth, wall.brickHeight);
                        Rectangle ballRect = new Rectangle(ball.getBallX(), ball.getBallY(), 20,20);
                        if(ballRect.intersects(brick)){
                            wall.wall[i][j] = 0;
                            ball.setBallDirectionXToOpposite();
                            ball.setBallDirectionYToOpposite();
                        }
                    }
                }
            }

        }

        gameRender.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
            if(spacecraft.getSpacecraftX() >= 490){
                spacecraft.setSpacecraftX(490);
            }
            else{
                this.moveRight();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT) {
            if(spacecraft.getSpacecraftX() <= 20) {
                spacecraft.setSpacecraftX(20);
            } else {
                this.moveLeft();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void moveLeft() {
        this.setGameState(true);
        spacecraft.addSpacecraftX(-10);
    }

    public void moveRight() {
        this.setGameState(true);
        spacecraft.addSpacecraftX(10);
    }

    public boolean getGameState() {
        return this.gameState;
    }

    public void setGameState(boolean state) {
        this.gameState = state;
    }

}
