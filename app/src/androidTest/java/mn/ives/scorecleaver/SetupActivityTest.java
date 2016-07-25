package mn.ives.scorecleaver;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SetupActivityTest {

    @Rule
    public ActivityTestRule<SetupActivity> mActivityRule = new ActivityTestRule<>(
            SetupActivity.class);

    @Test
    public void testSetupShouldHaveDefaultScoreOfFiftyOrFromPrefs() {
        String lastScore = mActivityRule.getActivity().getPreferences(Context.MODE_PRIVATE).getString(mActivityRule.getActivity().getString(R.string.last_starting_score), "50");
        onView(withId(R.id.startScore)).check(matches(withText(lastScore)));
    }

    @Test
    public void testSetupSendsValueToTwoPlayer() throws InterruptedException {
        // Update the starting score
        onView(withId(R.id.startScore)).perform(clearText());
        onView(withId(R.id.startScore)).perform(typeText("1234")).perform(closeSoftKeyboard());

        // Start two player game
        onView(withId(R.id.twoPlayerButton)).perform(click());

        onView(withId(R.id.playerOneScore)).check(matches(withText("1234")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("1234")));
    }

    @Test
    public void testSetupSendsValueToFourPlayer() throws InterruptedException {
        // Update the starting score
        onView(withId(R.id.startScore)).perform(clearText());
        onView(withId(R.id.startScore)).perform(typeText("1234")).perform(closeSoftKeyboard());

        // Start two player game
        onView(withId(R.id.fourPlayerButton)).perform(click());

        onView(withId(R.id.playerOneScore)).check(matches(withText("1234")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("1234")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("1234")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("1234")));
    }

    @Test
    public void testResumeSetsAppropriateValuesForTwoPlayers() {
        ScoreTestHelper.setScores(mActivityRule,2,15,25,0,0);

        onView(withId(R.id.resumeButton)).perform(click());

        onView(withId(R.id.playerOneScore)).check(matches(withText("15")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("25")));
    }

    @Test
    public void testResumeSetsAppropriateValuesForFourPlayers() {
        ScoreTestHelper.setScores(mActivityRule,4,15,25,35,45);

        onView(withId(R.id.resumeButton)).perform(click());

        onView(withId(R.id.playerOneScore)).check(matches(withText("15")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("25")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("35")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("45")));
    }
}