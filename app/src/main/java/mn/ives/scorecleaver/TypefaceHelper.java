package mn.ives.scorecleaver;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Used to help apply custom typefaces.
 */
public class TypefaceHelper {
    public static void applyAudiowide(AppCompatActivity activity, Integer...views) {
        Typeface custom_font = Typeface.createFromAsset(activity.getAssets(), "fonts/Audiowide-Regular.ttf");

        for (Integer viewId : views) {
            TextView textView = (TextView)activity.findViewById(viewId);
            textView.setTypeface(custom_font);
        }
    }
}
