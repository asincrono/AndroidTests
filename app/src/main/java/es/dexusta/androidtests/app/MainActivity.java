package es.dexusta.androidtests.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity implements OnFragmentInteractionListener {
    private static final boolean DEBUG = true;
    private static final String TAG = "MainActivity";

    private static final String KEY_CURRENT_FRAGMENT = "curr frag";
    private static final String KEY_FIRST_FRAGMENT = "first frag";
    private static final String KEY_SECOND_FRAGMENT = "second frag";
    private static final String KEY_THRID_FRAGMENT = "thrid frag";


    private int mCurrentFragment = 1;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), 2));

        mCurrentFragment = 1;
        if (savedInstanceState != null) {
            mCurrentFragment = savedInstanceState.getInt(KEY_CURRENT_FRAGMENT, 1);
        }

        mViewPager.setCurrentItem(mCurrentFragment - 1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_FRAGMENT, mCurrentFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mCurrentFragment == 1) {
            super.onBackPressed();
        } else {
            --mCurrentFragment;
            mViewPager.setCurrentItem(mCurrentFragment - 1, true);
        }
    }

    @Override
    public void onFragmentInteraction(String command) {
        Log.d(TAG, "Command: " + command);
        if (command == "next") {
            ++mCurrentFragment;
            mViewPager.setCurrentItem(mCurrentFragment - 1, true);
        } else if (command == "previous") {
            --mCurrentFragment;
            mViewPager.setCurrentItem(mCurrentFragment - 1, true);
        }
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        private final int mNumPages;

        private MyPagerAdapter(FragmentManager fm, int mNumPages) {
            super(fm);
            this.mNumPages = mNumPages;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return FirstFragment.newInstance();
            } else if (position == 1) {
                return SecondFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return mNumPages;
        }
    }
}
