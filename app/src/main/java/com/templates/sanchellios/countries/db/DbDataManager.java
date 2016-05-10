package com.templates.sanchellios.countries.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.templates.sanchellios.countries.country.ContinentConst;
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
        Cursor cursor = db.rawQuery("SELECT * FROM " + DbContracts.CountryTable.TABLE_NAME + ";", null);
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
        String DEFAULT_WIKI_URL = "https://simple.wikipedia.org/wiki/Country";
        String DEFAULT_COAT_OF_ARMS_URL = "http://acrath.org.au/wp-content/uploads/2014/10/U.N._Logo.jpg";
        String DEFAULT_FLAG_URL = "http://camoblood.ru/wp-content/uploads/2014/05/Flag_of_the_United_Nations.svg_.png";

        db = dbHelper.getWritableDatabase();

        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("Russia", 146544710, 3.685, ContinentConst.EUROPE);
        country.addInternetResources("https://en.wikipedia.org/wiki/Russia",
                "http://www.dio.mid.ru/0img/Garant117.gif",
                "http://www.dailybackgrounds.com/wp-content/uploads/2014/12/russian-flag-background.jpg");
        countries.add(country);

        country = new Country("USA", 322369319, 18.124, ContinentConst.NORTH_AMERICA);
        country.addInternetResources("https://en.wikipedia.org/wiki/United_States",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Great_Seal_of_the_United_States_(obverse).svg/2000px-Great_Seal_of_the_United_States_(obverse).svg.png",
                "http://www.webweaver.nu/clipart/img/misc/usa/united-states-flag.png");
        countries.add(country);

        country = new Country("Australia", 24079100, 1.137, ContinentConst.AUSTRALIA_AND_OCEANIA);
        country.addInternetResources("https://en.wikipedia.org/wiki/Australia",
                "https://upload.wikimedia.org/wikipedia/commons/7/78/Australian_Coat_of_Arms.png",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_(converted).svg/2000px-Flag_of_Australia_(converted).svg.png");
        countries.add(country);

        country = new Country("Germany", 81459000, 3.842, ContinentConst.EUROPE);
        country.addInternetResources(
                "https://en.wikipedia.org/wiki/Germany",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Coat_of_arms_of_Germany.svg/2000px-Coat_of_arms_of_Germany.svg.png",
                "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/1280px-Flag_of_Germany.svg.png");
        countries.add(country);

        country = new Country("Somalia", 10816143, 0.006, ContinentConst.AFRICA);
        country.addInternetResources(
                "https://en.wikipedia.org/wiki/Somalia",
                "http://abali.ru/wp-content/uploads/2011/01/gerb_somali_coa.png",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Flag_of_Somalia.svg/2000px-Flag_of_Somalia.svg.png");
        countries.add(country);

        country = new Country("Brazil", 205338000, 3.208, ContinentConst.SOUTH_AMERICA);
        country.addInternetResources(
                "https://en.wikipedia.org/wiki/Brazil",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Coat_of_arms_of_Brazil.svg/2000px-Coat_of_arms_of_Brazil.svg.png",
                "http://free.clipartof.com/53-Free-Bandeira-Do-Brasil-Flag-Of-Brazil-Clipart-Illustration.png");
        countries.add(country);

        country = new Country("China", 1376049000, 19.392, ContinentConst.ASIA);
        country.addInternetResources("https://en.wikipedia.org/wiki/China",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/National_Emblem_of_the_People's_Republic_of_China.svg/2000px-National_Emblem_of_the_People's_Republic_of_China.svg.png",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People's_Republic_of_China.svg/2000px-Flag_of_the_People's_Republic_of_China.svg.png");
        countries.add(country);

        parseArrayListOfCountriesToDb(countries);
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
