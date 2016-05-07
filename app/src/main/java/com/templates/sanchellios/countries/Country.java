package com.templates.sanchellios.countries;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class Country {
    private String countryName;
    private long population;
    private double gdp;
    private String continent;
    private CountryInternetResources internetResources = null;

    public Country(String countryName,
                   long population,
                   double gdp,
                   String continent){
        this.countryName = countryName;
        this.population = population;
        this.gdp = gdp;
        this.continent = continent;
    }

    public CountryInternetResources getInternetResources(){
        return internetResources;
    }
}
