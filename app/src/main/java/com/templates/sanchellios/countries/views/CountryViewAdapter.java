package com.templates.sanchellios.countries.views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.templates.sanchellios.countries.R;
import com.templates.sanchellios.countries.country.Country;

import java.util.ArrayList;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class CountryViewAdapter extends RecyclerView.Adapter<CountryViewAdapter.ViewHolder>{

    private ArrayList<Country> countries = new ArrayList<>();
    private Listener listener;
    private Context context;

    public CountryViewAdapter(ArrayList<Country> countries, Context context){
        this.context = context;
        this.countries = countries;
    }

    public interface Listener{
        void onClick(Country country);
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

        ImageView imageView = (ImageView)cardView.findViewById(R.id.small_flag);
        TextView countryTextView = (TextView)cardView.findViewById(R.id.country_name);
        TextView continentTextView = (TextView)cardView.findViewById(R.id.continent);

        final Country country = this.countries.get(position);
        Picasso.with(context)
                .load(country.getInternetResources().getSmallFlagImageURL())
                .fit()
                .placeholder(R.drawable.un_coat_of_arms)
                .into(imageView);

        countryTextView.setText(country.getCountryName());
        continentTextView.setText(country.getContinent());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(country);
                }
            }
        });
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

    public void setListener(Listener listener){
        this.listener = listener;
    }
}
