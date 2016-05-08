package com.templates.sanchellios.countries.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.templates.sanchellios.countries.R;
import com.templates.sanchellios.countries.db.DbDataManager;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class CountryFragment extends Fragment {
    public static final String COUNTRIES = "COUNTRIES";

    public static CountryFragment newInstance(){
        return new CountryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView)inflater.inflate(R.layout.country_recycler, container, false);
        DbDataManager dbDataManager = new DbDataManager(getContext().getApplicationContext());
        CountryViewAdapter adapter = new CountryViewAdapter(dbDataManager.loadAllCountriesFormDb());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return recyclerView;
    }
}
