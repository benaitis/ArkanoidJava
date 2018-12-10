package com.company;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.swing.Timer;

public class GameRender extends JPanel {

    private Timer timer;
    private int delay = 2;

    Ball ball = new Ball(-1,-2,120,350);
    Spacecraft spacecraft = new Spacecraft(300);

    private Wall wall;
    private BufferedImage spacecraftImg;
    private BufferedImage energyBallImg;
    private BufferedImage borderImg;

    public GameRender() throws Exception{
        spacecraftImg = ImageIO.read(new FileInputStream("VausSpacecraftLarge.png"));
        energyBallImg = ImageIO.read(new FileInputStream("EnergyBall.png"));
        borderImg = ImageIO.read(new FileInputStream("wall.png"));
        wall = new Wall(3,6);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        GameRules rules = new GameRules(spacecraft, ball, wall, this);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,600,700);

        wall.draw(g);

        g.drawImage(borderImg, 0, 0, 10, 700, null);
        g.drawImage(borderImg, 0, 0, 590, 10, null);
        g.drawImage(borderImg, 590, 0, 10, 700, null);
        g.drawImage(borderImg, 0,690,590,10,null);
        g.drawImage(spacecraftImg, spacecraft.getSpacecraftX(),550, 100, 10,null);

        g.drawImage(energyBallImg, ball.getBallX(), ball.getBallY(),20,20, null);

        g.dispose();
    }



}
