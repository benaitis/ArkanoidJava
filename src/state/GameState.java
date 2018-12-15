package state;

import com.company.Ball;
import com.company.Brick;
import com.company.Spacecraft;
import com.company.Wall;

public class GameState {
    private boolean isPlaying;
    private Ball ball;
    private Spacecraft spacecraft;
    private Wall wall;

    private int wallRowCount = 3;
    private int wallColumnCount = 5;
    private int spacecraftStartPosition = 300;
    private int ballDirectionXStart = -1;
    private int ballDirectionYStart = -2;
    private int ballStartX = 120;
    private int ballStartY = 350;

    public GameState(boolean isPlaying) throws Exception {
        this.isPlaying = isPlaying;
        this.ball = new Ball(ballDirectionXStart,ballDirectionYStart,ballStartX,ballStartY);;
        this.wall = new Wall(wallRowCount,wallColumnCount);
        this.spacecraft = new Spacecraft(spacecraftStartPosition);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public Spacecraft getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(Spacecraft spacecraft) {
        this.spacecraft = spacecraft;
    }
}
