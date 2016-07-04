package mn.ives.scorecleaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SetupActivity extends AppCompatActivity {
    public final static String EXTRA_SCORE = "mn.ives.scorecleaver.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
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
        Integer startScore = Integer.parseInt(scoreString);
        intent.putExtra(EXTRA_SCORE, startScore.intValue());
        startActivity(intent);
    }
}
