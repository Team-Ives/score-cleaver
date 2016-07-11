package mn.ives.scorecleaver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Courtney on 7/4/16.
 */
public class PlayerScoreTest {
    @Test
    public void currentHealthReturnsDefaultScore() {
        PlayerScore score = new PlayerScore(new AbstractScoreActivity(), 50, 50);
        assertEquals(50, score.currentHealth());
    }

    @Test
    public void healAddsOneToCurrentHealth() throws Exception {
        PlayerScore score = new PlayerScore(new AbstractScoreActivity(), 50, 50);
        score.heal();
        assertEquals(51, score.currentHealth());
    }

    @Test
    public void injureSubtractsOneToCurrentHealth() {
        PlayerScore score = new PlayerScore(new AbstractScoreActivity(), 50, 50);
        score.injure();
        assertEquals(49, score.currentHealth());
    }
}
