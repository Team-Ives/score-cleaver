package mn.ives.scorecleaver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.logging.Logger;

public class SetupActivity extends AppCompatActivity {
    public final static String EXTRA_SCORE = "mn.ives.scorecleaver.SCORE";

    private final static Logger log = Logger.getLogger("SetupActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.default_score);
        String lastValue = sharedPref.getString(getString(R.string.last_starting_score), defaultValue);

        TypefaceHelper.applyAudiowide(this, R.id.startScore, R.id.numPlayersLabel, R.id.startScoreLabel, R.id.resumeLabel);

        EditText startScoreTextEdit = (EditText)findViewById(R.id.startScore);
        startScoreTextEdit.setText(lastValue);
        startScoreTextEdit.setSelection(startScoreTextEdit.getText().length());
    }

    /**
     * Called when the user clicks the two player button.
     *
     * @param view
     */
    public void startTwoPlayerGame(View view){
        Intent intent = new Intent(this, DisplayTwoPlayerScoreActivity.class);
        EditText editText = (EditText) findViewById(R.id.startScore);
        String scoreString = editText.getText().toString();
        log.info(scoreString);
        this.storeLastStart(scoreString, 2);
        intent.putExtra(EXTRA_SCORE, scoreString);
        startActivity(intent);
    }

    /**
     * Called when the user clicks the four player button.
     *
     * @param view
     */
    public void startFourPlayerGame(View view){
        Intent intent = new Intent(this, DisplayFourPlayerScoreActivity.class);
        EditText editText = (EditText) findViewById(R.id.startScore);
        String scoreString = editText.getText().toString();
        log.info(scoreString);
        this.storeLastStart(scoreString, 4);
        intent.putExtra(EXTRA_SCORE, scoreString);
        startActivity(intent);
    }

    /**
     * Called when the user clicks the resume button.
     *
     * @param view
     */
    public void resumeGame(View view){
        Intent intent;

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int lastPlayers = sharedPref.getInt(getString(R.string.last_starting_players), 2);

        if(lastPlayers == 2) {
            intent = new Intent(this, DisplayTwoPlayerScoreActivity.class);
        } else {
            intent = new Intent(this, DisplayFourPlayerScoreActivity.class);
        }
        intent.putExtra(EXTRA_SCORE, String.valueOf(PlayerScore.RESTORE_SCORES));
        startActivity(intent);
    }

    private void storeLastStart(String value, int startingPlayers){
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.last_starting_score), value);
        editor.putInt(getString(R.string.last_starting_players), startingPlayers);
        editor.apply();
    }

}
