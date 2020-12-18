package com.example.lab1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import timber.log.Timber;

public class AboutFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Timber.i("AboutFragment onCreate called");

        final View view = inflater.inflate(R.layout.rules_fragment, container, false);

        return view;
    }

    private void setVisibility(int gone) {
    }

    @Override
    public void onStart() {
        super.onStart();
        Timber.i("AboutFragment onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.i("AboutFragment onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Timber.i("AboutFragment onPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Timber.i("AboutFragment onStop called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.i("AboutFragment onDestroy called");
    }

}