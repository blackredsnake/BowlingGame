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

    private void rollMany(int repetition, int pins) {
        for (int i = 0; i < repetition; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void gutterGame() throws Exception {

        rollMany(20, 0);
        Assert.assertEquals(0, game.score());
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        Assert.assertEquals(20, game.score());
    }


    @Test
    public void oneSpare() throws Exception {
        game.roll(5);
        game.roll(5); //spare
        game.roll(3);
        rollMany(17, 0);
        Assert.assertEquals(16, game.score());
    }

    @Test
    public void oneStrike() throws Exception {
        game.roll(10);//strike
        game.roll(3);
        game.roll(4);
        rollMany(16,0);
        Assert.assertEquals(24,game.score());
    }

    @Test
    public void allStrikes() throws Exception {
rollMany(12,10);
Assert.assertEquals(300,game.score());
    }
}
