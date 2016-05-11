package com.templates.sanchellios.countries.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.templates.sanchellios.countries.R;
import com.templates.sanchellios.countries.country.Country;
import com.templates.sanchellios.countries.views.data_formatters.GdpDimension;
import com.templates.sanchellios.countries.views.data_formatters.NumberFormatter;

public class DetailedActivity extends AppCompatActivity {
    public static String COUNTRY = "COUNTRY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Intent intent = getIntent();
        Country country = intent.getParcelableExtra(COUNTRY);

        setTitle(country.getCountryName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView = (ImageView)findViewById(R.id.da_flag_image);
        TextView continentLabel = (TextView)findViewById(R.id.da_continent_text_view);
        TextView populationLabel = (TextView)findViewById(R.id.da_population_text_view);
        TextView gdpLabel = (TextView)findViewById(R.id.da_gdp_text_view);

        Picasso.with(getApplicationContext())
                .load(country.getInternetResources().getBigFlagImageURL())
                .fit()
                .placeholder(R.drawable.un_flag)
                .into(imageView);

        continentLabel.setText(country.getContinent());
        populationLabel.setText(NumberFormatter.separateByComma(country.getPopulation()));
        gdpLabel.setText(GdpDimension.defineDimension(country.getGdp()));
    }
}
