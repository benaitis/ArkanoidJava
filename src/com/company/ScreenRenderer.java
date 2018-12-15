package com.company;
import state.GameState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ScreenRenderer extends JFrame implements KeyListener, ActionListener  {

    public static final int width = 600;
    public static final int height = 700;

    private Timer timer;
    private static final int delay = 4;


    public GameRules gameRules;
    public GameRender gameRender;

    public ScreenRenderer() throws Exception{
        super.setBounds(0,0, width, height);
        GameState gameState = new GameState(true);
        gameRender = new GameRender(gameState);
        gameRules = new GameRules(gameState);
        super.setTitle("Arkanoid žaidimas");
        super.setResizable(true);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.add(gameRender);
        timer = new Timer(delay, this);
        timer.start();
        gameRender.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.gameRules.actionPerformed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.gameRules.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.gameRules.keyReleased(e);
    }
}