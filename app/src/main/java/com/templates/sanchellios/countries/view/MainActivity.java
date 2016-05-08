package com.templates.sanchellios.countries.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.templates.sanchellios.countries.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startCountryListFrag();
    }

    private void startCountryListFrag(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.country_recycler_container, CountryFragment.newInstance())
                .commit();
    }
}
