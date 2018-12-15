package state;

import com.company.Ball;
import com.company.Brick;
import com.company.Spacecraft;
import com.company.Wall;

public class GameState {
    private boolean isPlaying;
    private Ball ball;
    // private Brick brick;
    private Spacecraft spacecraft;
    private Wall wall;

    public GameState(boolean isPlaying) throws Exception {
        this.isPlaying = isPlaying;
        this.ball = new Ball(-1,-2,120,350);;
        // this.brick = new Brick(3,6);
        this.wall = new Wall(3,6);
        this.spacecraft = new Spacecraft(300);
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

//    public Brick getBrick() {
//        return brick;
//    }
//
//    public void setBrick(Brick brick) {
//        this.brick = brick;
//    }


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
