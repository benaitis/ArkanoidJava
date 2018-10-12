package com.company;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.swing.Timer;

public class GameRender extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private Timer timer;
    private int delay = 2;

    Ball ball = new Ball(-1,-2,120,350);

    private Wall wall;
    private BufferedImage spacecraftImg;
    private BufferedImage energyBallImg;
    private BufferedImage borderImg;
    private Spacecraft spacecraft;

    public GameRender(Spacecraft spacecraft) throws Exception{
        this.spacecraft = spacecraft;
        spacecraftImg = ImageIO.read(new FileInputStream("VausSpacecraftLarge.png"));
        energyBallImg = ImageIO.read(new FileInputStream("EnergyBall.png"));
        borderImg = ImageIO.read(new FileInputStream("wall.png"));
        wall = new Wall(3,6);
        super.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
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


    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play) {
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
                play = false;
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

        this.repaint();
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
                moveRight();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT) {
            if(spacecraft.getSpacecraftX() <= 20) {
                spacecraft.setSpacecraftX(20);
            } else {
                moveLeft();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void moveLeft() {
        play = true;
        spacecraft.addSpacecraftX(-10);
    }
    public void moveRight() {
        play = true;
        spacecraft.addSpacecraftX(10);
    }
}
