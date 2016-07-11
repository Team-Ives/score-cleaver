package mn.ives.scorecleaver;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

/**
 * Used to keep track of player scores
 */
public class PlayerScore {
    public static int RESTORE_SCORES = -1;

    private int currentScore;
    private int playerId;
    private String playerUid;
    private AbstractScoreActivity activity;

    public PlayerScore(AbstractScoreActivity activity, int playerId, int startingScore) {
        this.activity = activity;
        this.playerId = playerId;
        this.playerUid = activity.getString(R.string.player_prefix) + String.valueOf(playerId);

        if(startingScore == RESTORE_SCORES) {
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
            this.currentScore = sharedPref.getInt(this.playerUid, startingScore);;
        } else {
            this.currentScore = startingScore;
        }

        this.setActivityScore(this.currentScore);
    }

    public void setActivityScore(int score){
        TextView textView = (TextView) this.activity.findViewById(this.playerId);
        textView.setText(String.valueOf(score));

        SharedPreferences sharedPref = this.activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(playerUid, score);
        editor.apply();
    }

    public int currentHealth(){
        return this.currentScore;
    }

    public void injure() {
        this.currentScore --;
        this.setActivityScore(this.currentScore);
    }

    public void heal() {
        this.currentScore ++;
        this.setActivityScore(this.currentScore);
    }
}
