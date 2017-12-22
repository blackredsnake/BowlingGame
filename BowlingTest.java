package BowlingGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    private void rollMany(int repitition, int pins) {
        for (int i = 0; i < repitition; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void gutterGame()throws Exception{

        rollMany(20, 0);
        Assert.assertEquals(0,game.score());
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        Assert.assertEquals(20,game.score());
    }


    @Test
    public void oneSpare() throws Exception {
        game.roll(5);
        game.roll(5); //spare
        game.roll(3);
        rollMany(17,0);
        Assert.assertEquals(16,game.score());
    }
}
