package mn.ives.scorecleaver;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.rule.ActivityTestRule;
import android.view.WindowManager;
import android.widget.TextView;

import static mn.ives.scorecleaver.SetupActivity.SHARED_PREF_SPACE;

/**
 * Just convenience method for setting a bunch of shared preferences.
 */
public class ScoreTestHelper {
    public static void setScores(ActivityTestRule mActivityRule, int numPlayers, int scores) {
        setScores(mActivityRule, numPlayers, scores, scores, scores, scores, scores);
    }

    public static void setScores(ActivityTestRule mActivityRule, int numPlayers, int playerOneScore, int playerTwoScore, int playerThreeScore, int playerFourScore) {
        setScores(mActivityRule, numPlayers, playerOneScore, playerTwoScore, playerThreeScore, playerFourScore, 50);
    }

    public static void setScores(ActivityTestRule mActivityRule, int numPlayers, int playerOneScore, int playerTwoScore, int playerThreeScore, int playerFourScore, int defaultScore) {
        String prefix = mActivityRule.getActivity().getString(R.string.player_prefix);
        SharedPreferences.Editor editor = mActivityRule.getActivity().getSharedPreferences(SHARED_PREF_SPACE, Context.MODE_PRIVATE).edit();
        editor.putInt(mActivityRule.getActivity().getString(R.string.last_starting_players), numPlayers);
        editor.putInt(prefix + String.valueOf(R.id.playerOneScore), playerOneScore);
        editor.putInt(prefix + String.valueOf(R.id.playerTwoScore), playerTwoScore);
        editor.putInt(prefix + String.valueOf(R.id.playerThreeScore), playerThreeScore);
        editor.putInt(prefix + String.valueOf(R.id.playerFourScore), playerFourScore);
        editor.putString(mActivityRule.getActivity().getString(R.string.last_starting_score), String.valueOf(defaultScore));
        editor.apply();
    }

    public static void keepActivityAwake(ActivityTestRule mActivityRule){
        final Activity activity = mActivityRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    public static void restartActivity(ActivityTestRule activityRule) {
        activityRule.getActivity().finish();
        activityRule.launchActivity(activityRule.getActivity().getIntent());
    }

    public static int getPotentialUpdatedScore(ActivityTestRule mActivityRule, int playerId, int addedValue) {
        return Integer.valueOf(((TextView) mActivityRule.getActivity().findViewById(playerId)).getText().toString()) + addedValue;
    }
}
