package mn.ives.scorecleaver;

import android.content.Intent;
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

        TypefaceHelper.applyAudiowide(this, R.id.startScore, R.id.numPlayersLabel, R.id.startScoreLabel);

        EditText startScoreTextEdit = (EditText)findViewById(R.id.startScore);
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
        intent.putExtra(EXTRA_SCORE, scoreString);
        startActivity(intent);
    }


}
