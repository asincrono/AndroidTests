package es.dexusta.androidtests.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by asincrono on 13/04/14.
 */
public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setXFraction(float xFraction) {
        setX(xFraction * getWidth());
    }

    public float getXFraction() {
        return getX() / getWidth();
    }
}
