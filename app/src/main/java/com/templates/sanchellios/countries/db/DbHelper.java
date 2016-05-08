package com.templates.sanchellios.countries.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.templates.sanchellios.countries.country.ContinentConst;
import com.templates.sanchellios.countries.country.Country;

import static com.templates.sanchellios.countries.db.DbContracts.*;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "countries.db";
    public static final int SCHEMA = 1;
    private static DbHelper instance = null;

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    public DbHelper getInstance(Context context){
        if(instance == null){
            instance = new DbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_COUNTRIES_TABLE_SCRIPT = "CREATE TABLE " + CountryTable.TABLE_NAME + " (" +
                CountryTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CountryTable.COUNTRY_NAME + " TEXT NOT NULL, " +
                CountryTable.POPULATION + " INTEGER NOT NULL, " +
                CountryTable.GDP + " REAL NOT NULL, " +
                CountryTable.CONTINENT + " TEXT NOT NULL, " +
                CountryTable.WIKI_PAGE_URL + " TEXT, " +
                CountryTable.FLAG_SMALL_IMAGE_URL + " TEXT, " +
                CountryTable.FLAG_BIG_IMAGE_URL + " TEXT);";
        db.execSQL(SQL_CREATE_COUNTRIES_TABLE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void fillWithDefaultData(SQLiteDatabase db){
        Country country = new Country("Russia", 148000000, 300, ContinentConst.EUROPE);

        String DEFAULT_WIKI_URL = "http://wikipedia.com";
        String DEFAULT_SMALL_IMAGE_URL = "http://wikipedia.com/01.jpg";
        String DEFAULT_BIG_IMAGE_URL = "http://wikipedia.com/02.jpg";

        country.addInternetResources(DEFAULT_WIKI_URL, DEFAULT_SMALL_IMAGE_URL, DEFAULT_BIG_IMAGE_URL);
        addCountryToDb(db, country);
        country = new Country("USA", 256000000, 2000, ContinentConst.NORTH_AMERICA);
        country.addInternetResources(DEFAULT_WIKI_URL, DEFAULT_SMALL_IMAGE_URL, DEFAULT_BIG_IMAGE_URL);
        addCountryToDb(db, country);
        country = new Country("Australia", 30000000, 450, ContinentConst.AUSTRALIA_AND_OCEANIA);
        country.addInternetResources(DEFAULT_WIKI_URL, DEFAULT_SMALL_IMAGE_URL, DEFAULT_BIG_IMAGE_URL);
        addCountryToDb(db, country);
        country = new Country("Germany", 78000000, 600, ContinentConst.EUROPE);
        country.addInternetResources(DEFAULT_WIKI_URL, DEFAULT_SMALL_IMAGE_URL, DEFAULT_BIG_IMAGE_URL);
        addCountryToDb(db, country);
    }

    private void addCountryToDb(SQLiteDatabase db, Country country){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CountryTable.COUNTRY_NAME, country.getCountryName());
        contentValues.put(CountryTable.POPULATION, country.getPopulation());
        contentValues.put(CountryTable.GDP, country.getGdp());
        contentValues.put(CountryTable.CONTINENT, country.getContinent());
        contentValues.put(CountryTable.WIKI_PAGE_URL, country.getInternetResources().getWikiUrl());
        contentValues.put(CountryTable.FLAG_SMALL_IMAGE_URL, country.getInternetResources().getSmallFlagImageURL());
        contentValues.put(CountryTable.FLAG_BIG_IMAGE_URL, country.getInternetResources().getBigFlagImageURL());
        if(isCountryExistInDb(country.getCountryName(), db)){
            db.update(CountryTable.TABLE_NAME, contentValues, CountryTable.COUNTRY_NAME + "='" + country.getCountryName() + "'", null);
        }else {
            db.insert(CountryTable.TABLE_NAME, null, contentValues);
        }
    }

    private boolean isCountryExistInDb(String countryName, SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT " + countryName + " FROM " + CountryTable.TABLE_NAME +
                " WHERE " + CountryTable.COUNTRY_NAME + "='" + countryName + "';", null);
        if(cursor.getCount() > 0){
            cursor.close();
            return true;
        }else {
            cursor.close();
            return false;
        }
    }
}
