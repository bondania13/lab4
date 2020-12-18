package com.example.lab1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import timber.log.Timber;

public class RulesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.i("RulesFragment onCreate called");

        final View view = inflater.inflate(R.layout.rules_fragment, container, false);

        return view;
    };
    @Override
    public void onStart() {
        super.onStart();
        Timber.i("RulesFragment onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.i("RulesFragment onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Timber.i("RulesFragment onPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Timber.i("RulesFragment onStop called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.i("RulesFragment onDestroy called");
    }
}

