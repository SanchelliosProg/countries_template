package com.templates.sanchellios.countries.country;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class Country implements Parcelable {
    private String countryName;
    private long population;
    private double gdp;
    private String continent;
    private CountryWebRes internetResources = null;

    public Country(String countryName,
                   long population,
                   double gdp,
                   String continent){
        this.countryName = countryName;
        this.population = population;
        this.gdp = gdp;
        this.continent = continent;
    }

    protected Country(Parcel in) {
        countryName = in.readString();
        population = in.readLong();
        gdp = in.readDouble();
        continent = in.readString();
        internetResources = in.readParcelable(CountryWebRes.class.getClassLoader());
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public void addInternetResources(String wikiURL, String smallImgURL, String bigImgURL){
        CountryWebRes internetResources = new CountryWebRes();
        internetResources.setAllUrls(wikiURL, smallImgURL, bigImgURL);
        this.internetResources = internetResources;
    }

    public CountryWebRes getInternetResources(){
        return internetResources;
    }

    public String getCountryName() {
        return countryName;
    }

    public long getPopulation() {
        return population;
    }

    public double getGdp() {
        return gdp;
    }

    public String getContinent() {
        return continent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(countryName);
        dest.writeLong(population);
        dest.writeDouble(gdp);
        dest.writeString(continent);
        dest.writeParcelable(internetResources, flags);
    }
}
