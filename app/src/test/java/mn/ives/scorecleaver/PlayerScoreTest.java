package mn.ives.scorecleaver;

import android.content.SharedPreferences;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * These are tests to validate the PlayerScore.
 */
public class PlayerScoreTest {
    private AbstractScoreActivity mockActivity = mock(AbstractScoreActivity.class);
    private SharedPreferences mockPrefs = mock(SharedPreferences.class);
    private SharedPreferences.Editor mockEditor = mock(SharedPreferences.Editor.class);

    @Before
    public void setupMock() {
        TextView mockView = mock(TextView.class);
        when(mockActivity.getString(anyInt())).thenReturn("foo");
        when(mockActivity.findViewById(anyInt())).thenReturn(mockView);
        when(mockActivity.getPreferences(anyInt())).thenReturn(mockPrefs);
        when(mockPrefs.edit()).thenReturn(mockEditor);
        mockEditor.apply(); // LOL, the linter gives a warning without this.
    }

    @Test
    public void currentHealthReturnsDefaultScore() {
        PlayerScore score = new PlayerScore(mockActivity, 50, 50);
        assertNotNull(score.currentHealth());
        assertEquals(50, score.currentHealth());
    }

    @Test
    public void healAddsOneToCurrentHealth() throws Exception {
        PlayerScore score = new PlayerScore(mockActivity, 50, 50);
        score.heal();
        assertEquals(51, score.currentHealth());
    }

    @Test
    public void injureSubtractsOneToCurrentHealth() {
        PlayerScore score = new PlayerScore(mockActivity, 50, 50);
        score.injure();
        assertEquals(49, score.currentHealth());
    }

    @Test
    public void testSetActivityScore() {
        PlayerScore score = new PlayerScore(mockActivity, 50, 50);
        score.setActivityScore(20);
        verify(mockEditor).putInt(anyString(), eq(20));
        verify(mockEditor, times(3)).apply();
    }

    @Test
    public void resumeSetsScoreFromPreferenceStore() {
        when(mockPrefs.getInt(anyString(), anyInt())).thenReturn(35);
        PlayerScore score = new PlayerScore(mockActivity, 50, PlayerScore.RESTORE_SCORES);
        assertEquals(35, score.currentHealth());
    }
}
