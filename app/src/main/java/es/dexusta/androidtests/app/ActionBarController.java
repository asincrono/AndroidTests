package es.dexusta.androidtests.app;

import android.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by asincrono on 19/04/14.
 */
public class ActionBarController {
    public static void showCustomAB(ActionBar actionBar, int layout) {
        if (actionBar != null) {
            //actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(false);
            if (layout > 0) {
                actionBar.setDisplayShowCustomEnabled(true);

                LayoutInflater inflater = LayoutInflater.from(actionBar.getThemedContext());
                final View actionBarCustomView = inflater.inflate(R.layout.actionbar_cancel_accept, null);

                actionBar.setCustomView(actionBarCustomView);
            }

        }
    }

    public static void showClassicAB(ActionBar actionBar) {
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowCustomEnabled(false);
    }
}
