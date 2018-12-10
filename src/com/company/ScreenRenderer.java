package com.company;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ScreenRenderer extends JFrame {

    public static final int width = 600;
    public static final int height = 700;
    public ScreenRenderer() throws Exception{
        super.setBounds(0,0, width, height);
        GameRender game = new GameRender();
        super.setTitle("Arkanoid žaidimas");
        super.setResizable(true);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.add(game);
    }

}