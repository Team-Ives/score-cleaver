package mn.ives.scorecleaver;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.WindowManager;

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
public class DisplayFourPlayerScoreActivityTest {
    @Rule
    public ActivityTestRule<DisplayFourPlayerScoreActivity> mActivityRule = new ActivityTestRule<>(DisplayFourPlayerScoreActivity.class);

    @Before
    public void setUp() {
        ScoreTestHelper.setScores(mActivityRule,4,50);
        ScoreTestHelper.restartActivity(mActivityRule);
        ScoreTestHelper.keepActivityAwake(mActivityRule);
    }

    @Test
    public void defaultsToFifty() {
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("50")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("50")));
    }

    @Test
    public void injurePlayerOne() {
        onView(withId(R.id.playerOneInjure)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("49")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("50")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("50")));
    }

    @Test
    public void injurePlayerTwo() {
        onView(withId(R.id.playerTwoInjure)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("49")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("50")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("50")));
    }

    @Test
    public void injurePlayerThree() {
        onView(withId(R.id.playerThreeInjure)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("49")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("50")));
    }

    @Test
    public void injurePlayerFour() {
        onView(withId(R.id.playerFourInjure)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("50")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("49")));
    }

    @Test
    public void healPlayerOne() {
        onView(withId(R.id.playerOneHeal)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("51")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("50")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("50")));
    }

    @Test
    public void healPlayerTwo() {
        onView(withId(R.id.playerTwoHeal)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("51")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("50")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("50")));
    }

    @Test
    public void healPlayerThree() {
        onView(withId(R.id.playerThreeHeal)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("51")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("50")));
    }

    @Test
    public void healPlayerFour() {
        onView(withId(R.id.playerFourHeal)).perform(click());
        onView(withId(R.id.playerOneScore)).check(matches(withText("50")));
        onView(withId(R.id.playerTwoScore)).check(matches(withText("50")));
        onView(withId(R.id.playerThreeScore)).check(matches(withText("50")));
        onView(withId(R.id.playerFourScore)).check(matches(withText("51")));
    }
}
