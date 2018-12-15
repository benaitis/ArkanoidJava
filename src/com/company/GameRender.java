package com.company;

import brickstate.RedBrickState;
import providers.FileProvider;
import state.GameState;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameRender extends JPanel {
    private BufferedImage spacecraftImg;
    private BufferedImage energyBallImg;
    private BufferedImage borderImg;
    private BufferedImage redBrickImg;
    private BufferedImage goldBrickImg;
    private FileProvider fileProvider = new FileProvider();
    private GameState state;

    private int gameScreenX = 0;
    private int gameScreenY = 0;
    private int gameScreenWidth = 600;
    private int gameScreenHeight = 700;

    public GameRender(GameState gameState) throws Exception{
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        borderImg = fileProvider.getBorderImg();
        spacecraftImg = fileProvider.getSpacecraftImg();
        energyBallImg = fileProvider.getEnergyBallImg();
        redBrickImg = fileProvider.getBrickImg();
        goldBrickImg = fileProvider.getBrickGoldImg();
        this.state = gameState;
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(gameScreenX,gameScreenY,gameScreenWidth,gameScreenHeight);

        this.drawImages(g);

        g.dispose();
    }

    public void drawImages(Graphics g) {
        state.getBall();
        state.getWall();
        state.getSpacecraft();
        this.drawBricks(g);
        this.drawBorders(g);
        this.drawSpacecraft(g);
        this.drawBall(g);
        this.repaint();
    }

    public void drawBorders(Graphics g) {
        g.drawImage(borderImg, 0, 0, 10, 700, null);
        g.drawImage(borderImg, 0, 0, 590, 10, null);
        g.drawImage(borderImg, 590, 0, 10, 700, null);
        g.drawImage(borderImg, 0,690,590,10,null);
    }

    public void drawSpacecraft(Graphics g) {
        g.drawImage(spacecraftImg, state.getSpacecraft().getSpacecraftX(),550, 100, 10,null);
    }

    public void drawBall(Graphics g) {
        g.drawImage(energyBallImg, state.getBall().getBallX(), state.getBall().getBallY(),20,20, null);
    }

    public void drawBricks(Graphics g) {
        for(int i = 0; i<state.getWall().getBricksRows().length; i++){
            for(int j = 0; j<state.getWall().getBricksColumns().length; j++){
                Brick[][] brick = state.getWall().getBricksRows();
                if(brick[i][j].isVisible()) {
                    BufferedImage brickImg;
                    if (brick[i][j].getState() instanceof  RedBrickState) {
                        brickImg = redBrickImg;
                    } else {
                        brickImg = goldBrickImg;
                    }
                    g.drawImage(brickImg,j*brick[i][j].getBrickWidth()+50,i*brick[i][j].getBrickHeight()+50,brick[i][j].getBrickWidth(),brick[i][j].getBrickHeight(), null);
                }
            }
        }
    }

}
