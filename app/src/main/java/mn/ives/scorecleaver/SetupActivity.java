package mn.ives.scorecleaver;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Logger;

public class SetupActivity extends AppCompatActivity {
    public final static String EXTRA_SCORE = "mn.ives.scorecleaver.SCORE";

    private final static Logger log = Logger.getLogger("SetupActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        TextView startScoreTextView = (TextView)findViewById(R.id.startScore);
        TextView startGameLabelTextView = (TextView)findViewById(R.id.startGameLabel);
        TextView startScoreLabelTextView = (TextView)findViewById(R.id.startScoreLabel);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Audiowide-Regular.ttf");

        startScoreTextView.setTypeface(custom_font);
        startGameLabelTextView.setTypeface(custom_font);
        startScoreLabelTextView.setTypeface(custom_font);
    }

    /**
     * Called when the user clicks the send button.
     *
     * @param view
     */
    public void startGame(View view){
        Intent intent = new Intent(this, DisplayScoreActivity.class);
        EditText editText = (EditText) findViewById(R.id.startScore);
        String scoreString = editText.getText().toString();
        log.info(scoreString);
        intent.putExtra(EXTRA_SCORE, scoreString);
        startActivity(intent);
        finish();
    }
}
