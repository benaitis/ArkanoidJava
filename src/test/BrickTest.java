package test;

import brickstate.GoldBrickState;
import com.company.Brick;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrickTest {

    @org.junit.jupiter.api.Test
    public void getState() {
        Brick brickTest = new Brick(1, 1, 1, 1, true);
        GoldBrickState goldBrickState = new GoldBrickState();
        brickTest.setState(goldBrickState);

        assertEquals(brickTest.getState().getClass(), goldBrickState.getClass());
    }

    @org.junit.jupiter.api.Test
    public void isVisible() {
        Brick brickTest = new Brick(1,1,1,1, true);
        brickTest.setVisibility(false);

        assertEquals(brickTest.isVisible(), false);
    }

}