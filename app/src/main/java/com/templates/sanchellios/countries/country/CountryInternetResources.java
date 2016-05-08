package com.templates.sanchellios.countries.country;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class CountryInternetResources {
    private String wikiUrl = null;
    private String smallFlagImageURL = null;
    private String bigFlagImageURL = null;

    public void setWikiUrl(String url){
        wikiUrl = url;
    }

    public void setSmallFlagImageURL(String url){
        smallFlagImageURL = url;
    }

    public void setBigFlagImageURL(String url){
        bigFlagImageURL = url;
    }

    public void setAllUrls(String wiki, String smallFlag, String bigFlag){
        wikiUrl = wiki;
        smallFlagImageURL = smallFlag;
        bigFlagImageURL = bigFlag;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public String getSmallFlagImageURL() {
        return smallFlagImageURL;
    }

    public String getBigFlagImageURL() {
        return bigFlagImageURL;
    }
}
