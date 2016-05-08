package com.templates.sanchellios.countries.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.templates.sanchellios.countries.db.DbContracts.CountryTable;

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

    public static DbHelper getInstance(Context context){
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
}
