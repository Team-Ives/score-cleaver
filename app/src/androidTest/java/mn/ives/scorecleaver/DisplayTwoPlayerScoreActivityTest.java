package mn.ives.scorecleaver;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DisplayTwoPlayerScoreActivityTest {
    @Rule
    public ActivityTestRule<SetupActivity> mActivityRule = new ActivityTestRule<>(SetupActivity.class);

    @Before
    public void setRestoreScoresToFifty() {
        ScoreTestHelper.setScores(mActivityRule,2,50,50,0,0);
        onView(withId(R.id.resumeButton)).perform(click());
    }

    @Test
    public void defaultsToFifty() {
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
    }

    @Test
    public void injurePlayerTwo() {
        onView(withId(R.id.playerTwoInjure)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("49")));
    }

    @Test
    public void healPlayerTwo() {
        onView(withId(R.id.playerTwoHeal)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("51")));
    }

    @Test
    public void injurePlayerOne() {
        onView(withId(R.id.playerOneInjure)).perform(click());
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerOneScore)).check(matches(withText("49")));
    }

    @Test
    public void healPlayerOne() {
        onView(withId(R.id.playerOneHeal)).perform(click());
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerOneScore)).check(matches(withText("51")));
    }
}
