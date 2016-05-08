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

    public void addInternetResources(String wikiURL, String smallImgURL, String bigImgURL){
        CountryInternetResources internetResources = new CountryInternetResources();
        internetResources.setAllUrls(wikiURL, smallImgURL, bigImgURL);
        this.internetResources = internetResources;
    }

    public CountryInternetResources getInternetResources(){
        return internetResources;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
