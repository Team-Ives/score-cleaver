package mn.ives.scorecleaver;

import android.widget.TextView;

/**
 * Used to keep track of player scores
 */
public class PlayerScore {
    private int currentScore;
    private int playerId;
    private AbstractScoreActivity activity;

    public PlayerScore(AbstractScoreActivity activity, int playerId, int startingScore) {
        this.currentScore = startingScore;
        this.activity = activity;
        this.playerId = playerId;

        this.setActivityScore(startingScore);
    }

    public void setActivityScore(int score){
        TextView textView = (TextView) this.activity.findViewById(this.playerId);
        textView.setText(String.valueOf(score));
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
