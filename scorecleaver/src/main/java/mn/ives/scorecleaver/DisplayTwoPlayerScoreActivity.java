package mn.ives.scorecleaver;

import android.content.Intent;
import android.os.Bundle;

import java.util.logging.Logger;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class DisplayTwoPlayerScoreActivity extends AbstractScoreActivity {

    private final static Logger log = Logger.getLogger("DisplayTwoPlayerScoreActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_two_player_score);

        Intent intent = getIntent();

        String startingScoreString = intent.getStringExtra(SetupActivity.EXTRA_SCORE);
        int startingScore = PlayerScore.RESTORE_SCORES;
        try {
            startingScore = Integer.parseInt(startingScoreString);
        } catch(NumberFormatException e){}

        PlayerScore playerOne = new PlayerScore(this, R.id.playerOneScore, startingScore);
        PlayerScore playerTwo = new PlayerScore(this, R.id.playerTwoScore, startingScore);

        super.injureMap.put(R.id.playerOneInjure, playerOne);
        super.injureMap.put(R.id.playerTwoInjure, playerTwo);

        super.healMap.put(R.id.playerOneHeal, playerOne);
        super.healMap.put(R.id.playerTwoHeal, playerTwo);

        TypefaceHelper.applyAudiowide(this, R.id.playerOneScore, R.id.playerTwoScore);
    }
}
