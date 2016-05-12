package com.templates.sanchellios.countries.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.templates.sanchellios.countries.R;
import com.templates.sanchellios.countries.country.Country;
import com.templates.sanchellios.countries.data.database.DbDataManager;

import java.util.ArrayList;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class CountryFragment extends Fragment {

    public static CountryFragment newInstance(){
        return new CountryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView)inflater.inflate(R.layout.country_recycler,
                container, false);
        setUpRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setUpRecyclerView(RecyclerView recyclerView){
        recyclerView.setAdapter(getAdapter());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    private CountryViewAdapter getAdapter(){
        CountryViewAdapter adapter = new CountryViewAdapter(getCountries(),
                getContext().getApplicationContext());
        setListenerToAdapter(adapter);
        return adapter;
    }

    private void setListenerToAdapter(CountryViewAdapter adapter){
        adapter.setListener(new CountryViewAdapter.Listener() {
            @Override
            public void onClick(Country country) {
                Intent intent = new Intent(getActivity(), DetailedActivity.class);
                intent.putExtra(DetailedActivity.COUNTRY, country);
                getActivity().startActivity(intent);
            }
        });
    }

    private ArrayList<Country> getCountries(){
        DbDataManager dbDataManager = new DbDataManager(getContext().getApplicationContext());
        return dbDataManager.loadAllCountriesFormDb();
    }
}
