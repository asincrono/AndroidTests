package es.dexusta.androidtests.app;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * Created by asincrono on 13/04/14.
 */
public class MyFrameLayout extends FrameLayout {
    private static final boolean DEBUG = true;
    private static final String TAG = "MyFrameLayout";

    public MyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setXFraction(float xFraction) {
        Log.d(TAG, "xFraction: " + xFraction);
        setX(xFraction/100 * getWidth());
    }


    public void setYFraction(float yFraction) {
        Log.d(TAG, "yFraction: " + yFraction);
        setY(yFraction/100 * getHeight());
    }

    public float getXFraction() {
        return (getX() / getWidth()) * 100;
    }

    public float getYFraction() {
        return (getY() / getHeight()) * 100;
    }
}
