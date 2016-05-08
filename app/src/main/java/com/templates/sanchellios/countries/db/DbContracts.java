package com.templates.sanchellios.countries.db;

import android.provider.BaseColumns;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class DbContracts {
    public static final class CountryTable implements BaseColumns{
        public static final String TABLE_NAME = "countries";
        public static final String COUNTRY_NAME = "name";
        public static final String POPULATION = "population";
        public static final String GDP = "gdp";
        public static final String CONTINENT = "continent";
        public static final String WIKI_PAGE_URL = "wiki_url";
        public static final String FLAG_SMALL_IMAGE_URL = "flag_url_small";
        public static final String FLAG_BIG_IMAGE_URL = "flag_url_big";
    }
}
