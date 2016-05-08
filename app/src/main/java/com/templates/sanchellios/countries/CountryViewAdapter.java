package com.templates.sanchellios.countries;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class CountryViewAdapter extends RecyclerView.Adapter<CountryViewAdapter.ViewHolder>{

    private ArrayList<Country> countries = new ArrayList<>();

    public CountryViewAdapter(ArrayList<Country> countries){
        this.countries = countries;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_card, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView countryTextView = (TextView)cardView.findViewById(R.id.country_name);
        TextView continentTextView = (TextView)cardView.findViewById(R.id.continent);

        Country country = this.countries.get(position);
        countryTextView.setText(country.getCountryName());
        continentTextView.setText(country.getContinent());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView view){
            super(view);
            cardView = view;
        }
    }


}
