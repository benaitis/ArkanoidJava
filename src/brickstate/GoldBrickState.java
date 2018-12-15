package brickstate;

import com.company.Brick;

public class GoldBrickState extends BrickState {

    @Override
    public void changeLifePoints(Brick brick) {
        brick.setState(new RedBrickState());
    }
}
