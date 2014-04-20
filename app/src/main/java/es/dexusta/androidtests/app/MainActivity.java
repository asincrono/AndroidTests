package es.dexusta.androidtests.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;


public class MainActivity extends Activity implements OnFragmentInteractionListener {
    private static final boolean DEBUG = true;
    private static final String TAG = "MainActivity";

    private static final String KEY_CURRENT_FRAGMENT = "curr frag";
    private static final String KEY_FIRST_FRAGMENT = "first frag";
    private static final String KEY_SECOND_FRAGMENT = "second frag";
    private static final String KEY_THRID_FRAGMENT = "thrid frag";

    private ActionBar mAB;
    private boolean mShowOptMenu = true;


    private int mCurrentFragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAB = getActionBar();

        mCurrentFragment = 1;
        if (savedInstanceState != null) {
            mCurrentFragment = savedInstanceState.getInt(KEY_CURRENT_FRAGMENT, 1);
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        Fragment fragment;

        if (mCurrentFragment == 1) {
            fragment = fm.findFragmentByTag(KEY_FIRST_FRAGMENT);
            if (fragment == null) {
                 fragment = FirstFragment.newInstance();
                 transaction.add(android.R.id.content, fragment, KEY_FIRST_FRAGMENT);
            } else {
                transaction.replace(android.R.id.content, fragment);
            }
        } else if (mCurrentFragment == 2) {
            fragment = fm.findFragmentByTag(KEY_SECOND_FRAGMENT);
            if (fragment == null) {
                fragment = SecondFragment.newInstance();
                transaction.add(android.R.id.content, fragment, KEY_SECOND_FRAGMENT);
            } else {
                transaction.replace(android.R.id.content, fragment);
            }
        }

        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_FRAGMENT, mCurrentFragment);
    }

    @Override
    public void onFragmentInteraction(String command) {
        Log.d(TAG, "Command: " + command);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        if (command.equals("next")) {
           if (mCurrentFragment == 1) {
               if (DEBUG) {
                   Log.d(TAG, "Current Fragment: " + mCurrentFragment);
               }
               transaction.setCustomAnimations(R.animator.enter_from_left, R.animator.exit_to_right);
               Fragment fragment = manager.findFragmentByTag(KEY_SECOND_FRAGMENT);
               if (fragment == null) {
                   fragment = SecondFragment.newInstance();
                   transaction.replace(android.R.id.content, fragment, KEY_SECOND_FRAGMENT);
               } else {
                   transaction.replace(R.id.content, fragment);
               }

               mCurrentFragment = 2;

           }
        } else if (command.equals("previous")) {
            transaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left);
            Fragment fragment = manager.findFragmentByTag(KEY_FIRST_FRAGMENT);
            if (fragment == null) {
                fragment = FirstFragment.newInstance();
                transaction.replace(android.R.id.content, fragment, KEY_FIRST_FRAGMENT);
            } else {
                transaction.replace(R.id.content, fragment);
            }
            mCurrentFragment = 1;
        }
        transaction.commit();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!mShowOptMenu) {

        }
        return true;
    }

    public void onClickToggleBtt(View view) {
        ToggleButton tggBtt = (ToggleButton) view;
        if (tggBtt.isChecked()) {
            mShowOptMenu = false;
            ActionBarController.showCustomAB(getActionBar(), R.layout.actionbar_cancel_accept);
        }
        else {
            mShowOptMenu = true;
            ActionBarController.showClassicAB(getActionBar());
            Log.d(TAG, "toggle button deactivated.");
        }
        invalidateOptionsMenu();
    }
}
