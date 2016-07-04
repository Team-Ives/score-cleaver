package mn.ives.scorecleaver;

/**
 * Used to keep track of player scores
 */
public class PlayerScore {
    private int currentScore;

    private String playerName;

    public PlayerScore(int startingScore, String playerName) {
        this.currentScore = startingScore;
        this.playerName = playerName;
    }

    public int currentHealth(){
        return this.currentScore;
    }

    public void injure() {
        this.currentScore --;
    }

    public void heal() {
        this.currentScore ++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
