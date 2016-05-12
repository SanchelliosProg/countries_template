package com.templates.sanchellios.countries.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.templates.sanchellios.countries.R;
import com.templates.sanchellios.countries.country.Country;
import com.templates.sanchellios.countries.data.manip.GdpDimension;
import com.templates.sanchellios.countries.data.manip.NumberFormatter;

public class DetailedActivity extends AppCompatActivity {
    public static String COUNTRY = "COUNTRY";
    private ImageView flagImage;
    private TextView continentLabel;
    private TextView populationLabel;
    private TextView gdpLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Country country = getCountryFromIntent();

        populateActionBar(country);
        initScreenElements();
        loadImage(country);
        populateTextViews(country);
    }

    private Country getCountryFromIntent(){
        Intent intent = getIntent();
        return intent.getParcelableExtra(COUNTRY);
    }

    private void populateActionBar(Country country){
        setTitle(country.getCountryName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initScreenElements(){
        flagImage = (ImageView)findViewById(R.id.da_flag_image);
        continentLabel = (TextView)findViewById(R.id.da_continent_text_view);
        populationLabel = (TextView)findViewById(R.id.da_population_text_view);
        gdpLabel = (TextView)findViewById(R.id.da_gdp_text_view);
    }

    private void loadImage(Country country){
        Picasso.with(getApplicationContext())
                .load(country.getInternetResources().getBigFlagImageURL())
                .fit()
                .placeholder(R.drawable.un_flag)
                .into(flagImage);
    }

    private void populateTextViews(Country country){
        continentLabel.setText(country.getContinent());
        populationLabel.setText(NumberFormatter.separateByComma(country.getPopulation()));
        gdpLabel.setText(GdpDimension.defineDimension(country.getGdp()));
    }
}
