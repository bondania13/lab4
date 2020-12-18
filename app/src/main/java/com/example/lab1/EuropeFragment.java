package com.example.lab1;


import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Fragment;

import timber.log.Timber;


public class EuropeFragment extends Fragment implements View.OnClickListener {

    String[] currencies_eu = {"Євро EUR", "Фунт Стерлінгів GBP", "Крона DKK", "Гривня UAH", "Злотий PLN"};

    TextView result_field_eu;
    TextView amount_input_eu;
    TextView res_text_eu;

    public Button convert_eu_button;


    String from_currency_eu = "";
    String to_currency_eu = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.europe_fragment, container, false);
        Timber.i("EuropeFragment onCreate called");

        convert_eu_button = (Button) view.findViewById(R.id.convert_eu_button);
        convert_eu_button.setOnClickListener((View.OnClickListener) this);

        amount_input_eu = (EditText) view.findViewById(R.id.amount_input_eu);
        result_field_eu = (EditText) view.findViewById(R.id.result_field_eu);

        Spinner spinner_from_eu = (Spinner) view.findViewById(R.id.currencies_from_spinner_eu);
        spinner_from_eu.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, currencies_eu));


        Spinner spinner_to_eu = (Spinner) view.findViewById(R.id.currencies_to_spinner_eu);
        spinner_to_eu.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, currencies_eu));



        /*View.OnClickListener onClickListener_eu = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.convert_eu_button:
                        res_text_eu.setText("Щоб конвертувати американські валюти, поверніться на попереднє вікно та натисніть кнопку Америка");
                        break;
                }
            }
        };
        convert_eu_button.setOnClickListener(onClickListener_eu);*/


        spinner_from_eu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                from_currency_eu = spinner_from_eu.getItemAtPosition(position).toString();
                Timber.i("EuropeFragment got from_currency_eu");
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinner_to_eu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                to_currency_eu = spinner_to_eu.getItemAtPosition(position).toString();
                Timber.i("EuropeFragment got to_currency_eu");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        return view;
    }



    @Override
    public void onClick(View v)
    {
        onOperationClick_eu(v);
        Timber.i("EuropeFragment click to convert");
    }

        public void onOperationClick_eu(View view){
            String amount = amount_input_eu.getText().toString();
            Timber.i("EuropeFragment got amount_input_eu");
            if(amount.length()>0){
                try{
                    performOperation_eu(Double.valueOf(amount));
                }catch (NumberFormatException ex){
                    amount_input_eu.setText("");
                }
            }
        }

        private void performOperation_eu(double amount){
            double result = 0;
            Timber.i("EuropeFragment converting...");
            if (from_currency_eu == "Євро EUR" && to_currency_eu =="Євро EUR"){
                result = amount;
            }
            else if (from_currency_eu == "Євро EUR" && to_currency_eu =="Фунт Стерлінгів GBP"){
                result = amount * 0.9;
            }
            else if (from_currency_eu == "Євро EUR" && to_currency_eu =="Крона DKK"){
                result = amount * 26.2;
            }
            else if (from_currency_eu == "Євро EUR" && to_currency_eu =="Гривня UAH"){
                result = amount * 33.9;
            }
            else if (from_currency_eu == "Євро EUR" && to_currency_eu =="Злотий PLN"){
                result = amount * 4.43;
            }


            else if (from_currency_eu == "Фунт Стерлінгів GBP" && to_currency_eu =="Євро EUR"){
                result = amount * 1.11;
            }
            else if (from_currency_eu == "Фунт Стерлінгів GBP" && to_currency_eu =="Бразильський реал BRL"){
                result = amount;
            }
            else if (from_currency_eu == "Фунт Стерлінгів GBP" && to_currency_eu =="Крона DKK"){
                result = amount * 29.09;
            }
            else if (from_currency_eu == "Фунт Стерлінгів GBP" && to_currency_eu =="Гривня UAH"){
                result = amount * 37.64;
            }
            else if (from_currency_eu == "Фунт Стерлінгів GBP" && to_currency_eu =="Злотий PLN"){
                result = amount * 4.92;
            }


            else if (from_currency_eu == "Крона DKK" && to_currency_eu =="Євро EUR"){
                result = amount * 0.038;
            }
            else if (from_currency_eu == "Крона DKKP" && to_currency_eu =="Фунт Стерлінгів GBP"){
                result = amount * 0.034;
            }
            else if (from_currency_eu == "Крона DKK" && to_currency_eu =="Крона DKK"){
                result = amount;
            }
            else if (from_currency_eu == "Крона DKK" && to_currency_eu =="Гривня UAH"){
                result = amount * 1.29;
            }
            else if (from_currency_eu == "Крона DKK" && to_currency_eu =="Злотий PLN"){
                result = amount * 0.17;
            }


            else if (from_currency_eu == "Гривня UAH" && to_currency_eu =="Євро EUR"){
                result = amount * 0.029;
            }
            else if (from_currency_eu == "Гривня UAH" && to_currency_eu =="Фунт Стерлінгів GBP"){
                result = amount * 0.027;
            }
            else if (from_currency_eu == "Гривня UAH" && to_currency_eu =="Крона DKK"){
                result = amount * 0.77;
            }
            else if (from_currency_eu == "Гривня UAH" && to_currency_eu =="Гривня UAH"){
                result = amount;
            }
            else if (from_currency_eu == "Гривня UAH" && to_currency_eu =="Злотий PLN"){
                result = amount * 0.13;
            }


            else if (from_currency_eu == "Злотий PLN" && to_currency_eu =="Євро EURS"){
                result = amount * 0.23;
            }
            else if (from_currency_eu == "Злотий PLN" && to_currency_eu =="Фунт Стерлінгів GBP"){
                result = amount * 0.2;
            }
            else if (from_currency_eu == "Злотий PLN" && to_currency_eu =="Крона DKK"){
                result = amount * 5.92;
            }
            else if (from_currency_eu == "Злотий PLN" && to_currency_eu =="Гривня UAH"){
                result = amount * 7.65;
            }
            else if (from_currency_eu == "Злотий PLN" && to_currency_eu =="Злотий PLN"){
                result = amount;
            }

            result_field_eu.setText(Double.toString(result));
        }
    @Override
    public void onStart() {
        super.onStart();
        Timber.i("EuropeFragment onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.i("EuropeFragment onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Timber.i("EuropeFragment onPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Timber.i("EuropeFragment onStop called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.i("EuropeFragment onDestroy called");
    }
    }


