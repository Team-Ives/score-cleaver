package mn.ives.scorecleaver;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.rule.ActivityTestRule;

import static mn.ives.scorecleaver.SetupActivity.SHARED_PREF_SPACE;

/**
 * Just convenience method for setting a bunch of shared preferences.
 */
public class ScoreTestHelper {
    public static void setScores(ActivityTestRule mActivityRule, int numPlayers, int playerOneScore, int playerTwoScore, int playerThreeScore, int playerFourScore) {
        String prefix = mActivityRule.getActivity().getString(R.string.player_prefix);
        SharedPreferences.Editor editor = mActivityRule.getActivity().getSharedPreferences(SHARED_PREF_SPACE, Context.MODE_PRIVATE).edit();
        editor.putInt(mActivityRule.getActivity().getString(R.string.last_starting_players), numPlayers);
        editor.putInt(prefix + String.valueOf(R.id.playerOneScore), playerOneScore);
        editor.putInt(prefix + String.valueOf(R.id.playerTwoScore), playerTwoScore);
        editor.putInt(prefix + String.valueOf(R.id.playerThreeScore), playerThreeScore);
        editor.putInt(prefix + String.valueOf(R.id.playerFourScore), playerFourScore);
        editor.apply();
    }
}
