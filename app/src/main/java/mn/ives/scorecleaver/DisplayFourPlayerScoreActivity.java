package mn.ives.scorecleaver;

import android.content.Intent;
import android.os.Bundle;

import java.util.logging.Logger;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class DisplayFourPlayerScoreActivity extends AbstractScoreActivity {

    private final static Logger log = Logger.getLogger("DisplayFourPlayerScoreActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        log.info("Creating 4 player game");

        setContentView(R.layout.activity_display_four_player_score);

        Intent intent = getIntent();

        String startingScoreString = intent.getStringExtra(SetupActivity.EXTRA_SCORE);
        int startingScore = Integer.parseInt(startingScoreString);

        PlayerScore playerOne = new PlayerScore(this, R.id.playerOneScore, startingScore);
        PlayerScore playerTwo = new PlayerScore(this, R.id.playerTwoScore, startingScore);
        PlayerScore playerThree = new PlayerScore(this, R.id.playerThreeScore, startingScore);
        PlayerScore playerFour = new PlayerScore(this, R.id.playerFourScore, startingScore);

        super.injureMap.put(R.id.playerOneInjure, playerOne);
        super.injureMap.put(R.id.playerTwoInjure, playerTwo);
        super.injureMap.put(R.id.playerThreeInjure, playerThree);
        super.injureMap.put(R.id.playerFourInjure, playerFour);

        super.healMap.put(R.id.playerOneHeal, playerOne);
        super.healMap.put(R.id.playerTwoHeal, playerTwo);
        super.healMap.put(R.id.playerThreeHeal, playerThree);
        super.healMap.put(R.id.playerFourHeal, playerFour);

        TypefaceHelper.applyAudiowide(this, R.id.playerOneScore, R.id.playerTwoScore, R.id.playerThreeScore, R.id.playerFourScore);
    }
}
