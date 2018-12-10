package com.company;

public class Ball {
    public int ballDirectionX;
    public int ballDirectionY;
    public int ballX;
    public int ballY;

    public Ball(int ballDirectionX, int ballDirectionY, int ballX, int ballY) {
        this.ballDirectionX = ballDirectionX;
        this.ballDirectionY = ballDirectionY;
        this.ballX = ballX;
        this.ballY = ballY;
    }

    public int getBallDirectionX() {
        return ballDirectionX;
    }

    public void setBallDirectionXToOpposite() {
        this.ballDirectionX = -ballDirectionX;
    }

    public int getBallDirectionY() {
        return ballDirectionY;
    }

    public void setBallDirectionYToOpposite() {
        this.ballDirectionY = -ballDirectionY;
    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public void setBallX(int ballX) {
        this.ballX += ballX;
    }

    public void setBallY(int ballY) {
        this.ballY += ballY;
    }
}
