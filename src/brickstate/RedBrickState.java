package brickstate;

import com.company.Brick;

public class RedBrickState extends BrickState {

    @Override
    public void changeLifePoints(Brick brick) {
        brick.setState(new GoldBrickState());
    }
}
