package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import timber.log.Timber;


public class MainActivity extends AppCompatActivity {

    public Button convert_am_button;
    public Button convert_eu_button;

    public Button about_button;
    public Button rules_button;
    public LinearLayout buttonsOpen;
    Timer timer;
    TextView result_field_eu;
    TextView amount_input_eu;

    TextView result_field_am;
    TextView amount_input_am;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.i("MainActivity onCreate called");
        setContentView(R.layout.activity_main);

            timer = new Timer();
            getLifecycle().addObserver(timer);

        about_button = (Button) findViewById((R.id.openAbout));
        rules_button = (Button) findViewById((R.id.openRules));

        amount_input_eu = (EditText) findViewById(R.id.amount_input_eu);
        result_field_eu = (EditText) findViewById(R.id.result_field_eu);

        amount_input_am = (EditText) findViewById(R.id.amount_input_am);
        result_field_am = (EditText) findViewById(R.id.result_field_am);

        convert_eu_button = findViewById(R.id.convert_eu_button);
        convert_am_button = findViewById(R.id.convert_am_button);
        buttonsOpen = (LinearLayout) findViewById((R.id.buttons));

        EuropeFragment europeFragment = (EuropeFragment)getFragmentManager().findFragmentById(R.id.europeFragment);
        AmericaFragment americaFragment = (AmericaFragment)getFragmentManager().findFragmentById(R.id.americaFragment);

        AboutFragment aboutFragment = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
        RulesFragment rulesFragment = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);

        europeFragment.getView().setVisibility(View.GONE);
        americaFragment.getView().setVisibility(View.GONE);
        aboutFragment.getView().setVisibility(View.GONE);
        rulesFragment.getView().setVisibility(View.GONE);


        if (savedInstanceState != null){
            amount_input_eu.setText(savedInstanceState.getString("amount_input_eu"));
            result_field_eu.setText(savedInstanceState.getString("result_field_eu"));

            amount_input_am.setText(savedInstanceState.getString("amount_input_am"));
            result_field_am.setText(savedInstanceState.getString("result_field_am"));
        }

    }


    public void openAMconverter(View view) {
        Timber.i("AmericaFragment openAMconverter called");
        AmericaFragment mapFragment = (AmericaFragment) getFragmentManager().findFragmentById(R.id.americaFragment);
        mapFragment.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }

    public void openEUconverter(View view) {
        Timber.i("EuropeFragment openEUconverter called");
        EuropeFragment mapFragment = (EuropeFragment) getFragmentManager().findFragmentById(R.id.europeFragment);
        mapFragment.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }


    public void openAbout(View view) {
        Timber.i("AboutFragment openAbout called");
        AboutFragment mapFragment = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
        mapFragment.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }

    public void openRules(View view) {
        Timber.i("RulesFragment openRules called");
        RulesFragment rules = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);
        rules.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }

    public void closeButton(View view) {
        Timber.i("closeButton called");
        AboutFragment aboutF = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
        aboutF.getView().setVisibility(View.GONE);


        AmericaFragment americaF = (AmericaFragment) getFragmentManager().findFragmentById(R.id.americaFragment);
        americaF.getView().setVisibility(View.GONE);


        EuropeFragment europeF = (EuropeFragment) getFragmentManager().findFragmentById(R.id.europeFragment);
        europeF.getView().setVisibility(View.GONE);


        RulesFragment rulesF = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);
        rulesF.getView().setVisibility(View.GONE);
        buttonsOpen.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Timber.i("menu creation");
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.set_eu) {
            Timber.i("EuropeFragment in menu selected");
            EuropeFragment europe = (EuropeFragment) getFragmentManager().findFragmentById(R.id.europeFragment);
            europe.getView().setVisibility(View.VISIBLE);
            buttonsOpen.setVisibility(View.GONE);
        }
        if (id == R.id.set_am) {
            Timber.i("AmericaFragment in menu selected");
            AmericaFragment america = (AmericaFragment) getFragmentManager().findFragmentById(R.id.americaFragment);
            america.getView().setVisibility(View.VISIBLE);
            buttonsOpen.setVisibility(View.GONE);

        }
        if (id == R.id.set_about) {
            Timber.i("AboutFragment in menu selected");
            AboutFragment about = (AboutFragment) getFragmentManager().findFragmentById(R.id.aboutFragment);
            about.getView().setVisibility(View.VISIBLE);
            buttonsOpen.setVisibility(View.GONE);

        }
        if (id == R.id.set_rules) {
            Timber.i("RulesFragment in menu selected");
            RulesFragment rules = (RulesFragment) getFragmentManager().findFragmentById(R.id.rulesFragment);
            rules.getView().setVisibility(View.VISIBLE);
            buttonsOpen.setVisibility(View.GONE);

        }
        if (id == R.id.set_share) {
            Timber.i("Share in menu selected");
            EuropeFragment europeFragment = (EuropeFragment) getFragmentManager().findFragmentById(R.id.europeFragment);

            if (europeFragment.isResumed()) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Ось така сума виходить: " + europeFragment.result_field_eu.getText();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share result"));
                return true;
            } else {
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }



    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("amount_input_eu",amount_input_eu.getText().toString());
        outState.putString("result_field_eu",result_field_eu.getText().toString());

        outState.putString("amount_input_am",amount_input_am.getText().toString());
        outState.putString("result_field_am",result_field_am.getText().toString());

        Timber.i("onSaveInstanceState");
    }

    protected void onStart() {
        super.onStart();
        Timber.i("MainActivity onStart called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Timber.i("MainActivity onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.i("MainActivity onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.i("MainActivity onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.i("MainActivity onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Timber.i("MainActivity onRestart called");
    }
}
