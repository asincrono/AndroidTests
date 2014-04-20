package es.dexusta.androidtests.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class SecondFragment extends Fragment {
    private static final boolean DEBUG = true;
    private static final String TAG = "SecondFragment";

    private OnFragmentInteractionListener mListener;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DEBUG)
            Log.d(TAG, "onCreate.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (DEBUG)
            Log.d(TAG, "onCreateView.");
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        if (view == null) throw new AssertionError("The inflated view can't be null.");
        Button bttPrev = (Button) view.findViewById(R.id.btt_prev);
        bttPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction("previous");
            }
        });
        Button bttNext = (Button) view.findViewById(R.id.btt_next);
        bttNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction("next");
            }
        });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (DEBUG)
            Log.d(TAG, "onResume.");
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        if (DEBUG)
            Log.d(TAG, "onCreateAnimator, (enter: " + enter + ").");
        return super.onCreateAnimator(transit, enter, nextAnim);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (DEBUG)
            Log.d(TAG, "onStart.");
    }

    @Override
    public void onPause() {
        super.onPause();
        if (DEBUG)
            Log.d(TAG, "onPause.");
    }

    @Override
    public void onStop() {
        super.onStop();
        if (DEBUG)
            Log.d(TAG, "onStop.");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (DEBUG)
            Log.d(TAG, "onActivityCreated.");

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (DEBUG)
            Log.d(TAG, "onConfigurationChanged");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (DEBUG)
            Log.d(TAG, "onDestroy");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (DEBUG)
            Log.d(TAG, "onAttach.");
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (DEBUG)
            Log.d(TAG, "onDetach.");
        mListener = null;
    }

}
