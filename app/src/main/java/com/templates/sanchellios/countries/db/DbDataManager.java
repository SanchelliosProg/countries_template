package com.templates.sanchellios.countries.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.templates.sanchellios.countries.country.Country;

import java.util.ArrayList;

import static com.templates.sanchellios.countries.db.DbContracts.CountryTable;

/**
 * Created by aleksandrvasilenko on 08.05.16.
 */
public class DbDataManager {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public DbDataManager(Context context){
        dbHelper = DbHelper.getInstance(context);
    }

    public ArrayList<Country> loadAllCountriesFormDb(){
        ArrayList<Country> countries = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DbContracts.CountryTable.TABLE_NAME +
                " ORDER BY "+ CountryTable.COUNTRY_NAME+" ASC;", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String countryName, continent, wikiUrl, smallImgUrl, bigImgUrl;
            long population;
            double gdp;
            countryName = cursor.getString(cursor.getColumnIndex(CountryTable.COUNTRY_NAME));
            continent = cursor.getString(cursor.getColumnIndex(CountryTable.CONTINENT));
            population = cursor.getLong(cursor.getColumnIndex(CountryTable.POPULATION));
            gdp = cursor.getDouble(cursor.getColumnIndex(CountryTable.GDP));
            wikiUrl = cursor.getString(cursor.getColumnIndex(CountryTable.WIKI_PAGE_URL));
            smallImgUrl = cursor.getString(cursor.getColumnIndex(CountryTable.FLAG_SMALL_IMAGE_URL));
            bigImgUrl = cursor.getString(cursor.getColumnIndex(CountryTable.FLAG_BIG_IMAGE_URL));
            Country country = new Country(countryName, population, gdp, continent);
            country.addInternetResources(wikiUrl, smallImgUrl, bigImgUrl);
            countries.add(country);
            cursor.moveToNext();
        }
        cursor.close();
        return countries;
    }

    public boolean isDbEmpty(){
        db = dbHelper.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + CountryTable.TABLE_NAME + ";";
        Cursor cursor = db.rawQuery(sqlQuery, null);
        return cursor.getCount() <= 0;
    }

    public void fillWithDefaultData(){
        db = dbHelper.getWritableDatabase();
        parseArrayListOfCountriesToDb(DefaultData.getDefaultData());
    }

    private void parseArrayListOfCountriesToDb(ArrayList<Country> countries){
        for(int i = 0; i < countries.size(); i++){
            addCountryToDb(countries.get(i));
        }
    }

    private void addCountryToDb(Country country){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContracts.CountryTable.COUNTRY_NAME, country.getCountryName());
        contentValues.put(DbContracts.CountryTable.POPULATION, country.getPopulation());
        contentValues.put(DbContracts.CountryTable.GDP, country.getGdp());
        contentValues.put(DbContracts.CountryTable.CONTINENT, country.getContinent());
        contentValues.put(DbContracts.CountryTable.WIKI_PAGE_URL, country.getInternetResources().getWikiUrl());
        contentValues.put(DbContracts.CountryTable.FLAG_SMALL_IMAGE_URL, country.getInternetResources().getSmallFlagImageURL());
        contentValues.put(DbContracts.CountryTable.FLAG_BIG_IMAGE_URL, country.getInternetResources().getBigFlagImageURL());
        if(isCountryExistInDb(country.getCountryName(), db)){
            db.update(DbContracts.CountryTable.TABLE_NAME, contentValues, DbContracts.CountryTable.COUNTRY_NAME + "='" + country.getCountryName() + "'", null);
        }else {
            db.insert(DbContracts.CountryTable.TABLE_NAME, null, contentValues);
        }
    }

    private boolean isCountryExistInDb(String countryName, SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT " + DbContracts.CountryTable.COUNTRY_NAME + " FROM " + DbContracts.CountryTable.TABLE_NAME +
                " WHERE " + DbContracts.CountryTable.COUNTRY_NAME + "='" + countryName + "';", null);
        if(cursor.getCount() > 0){
            cursor.close();
            return true;
        }else {
            cursor.close();
            return false;
        }
    }
}
