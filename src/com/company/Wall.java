package com.company;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class Wall {
    public int wall[][];
    public int brickWidth;
    public int brickHeight;
    private BufferedImage WallImg;

    public Wall(int row, int column) throws Exception{
        WallImg = ImageIO.read(new FileInputStream("BlueWall.png"));
        wall = new int[row][column];
        for(int i=0; i<wall.length; i++){
            for(int j=0;j<wall[0].length;j++){
                wall[i][j] = 1;
            }
        }
        brickWidth = 500/column;
        brickHeight = 150/row;
    }

    public void draw(Graphics g){
        for(int i=0;i<wall.length;i++){
            for(int j=0;j<wall[0].length;j++){
                if(wall[i][j] != 0) {
                    g.drawImage(WallImg,j*brickWidth+50,i*brickHeight+50,brickWidth,brickHeight, null);
                }
            }
        }
    }

}
