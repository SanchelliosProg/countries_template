package com.templates.sanchellios.countries.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.templates.sanchellios.countries.R;
import com.templates.sanchellios.countries.db.DbDataManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbDataManager dataManager = new DbDataManager(getApplicationContext());
        if(dataManager.isDbEmpty()){
            dataManager.fillWithDefaultData();
        }
        startCountryListFrag();
    }

    private void startCountryListFrag(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.country_container, CountryFragment.newInstance())
                .commit();
    }
}