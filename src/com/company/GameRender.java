package com.company;

import providers.FileProvider;
import state.GameState;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameRender extends JPanel {
    private BufferedImage spacecraftImg;
    private BufferedImage energyBallImg;
    private BufferedImage borderImg;
    private BufferedImage brickImg;
    private FileProvider fileProvider = new FileProvider();
    private GameState state;

    public GameRender(GameState gameState) throws Exception{
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        borderImg = fileProvider.getBorderImg();
        spacecraftImg = fileProvider.getSpacecraftImg();
        energyBallImg = fileProvider.getEnergyBallImg();
        brickImg = fileProvider.getBrickImg();
        this.state = gameState;
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,600,700);

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
                    g.drawImage(brickImg,j*brick[i][j].getBrickWidth()+50,i*brick[i][j].getBrickHeight()+50,brick[i][j].getBrickWidth(),brick[i][j].getBrickHeight(), null);
                }
            }
        }
    }

}
