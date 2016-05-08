package com.templates.sanchellios.countries.country;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aleksandrvasilenko on 07.05.16.
 */
public class CountryWebRes implements Parcelable {
    private String wikiUrl = null;
    private String smallFlagImageURL = null;
    private String bigFlagImageURL = null;

    public CountryWebRes(){}

    protected CountryWebRes(Parcel in) {
        wikiUrl = in.readString();
        smallFlagImageURL = in.readString();
        bigFlagImageURL = in.readString();
    }

    public static final Creator<CountryWebRes> CREATOR = new Creator<CountryWebRes>() {
        @Override
        public CountryWebRes createFromParcel(Parcel in) {
            return new CountryWebRes(in);
        }

        @Override
        public CountryWebRes[] newArray(int size) {
            return new CountryWebRes[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wikiUrl);
        dest.writeString(smallFlagImageURL);
        dest.writeString(bigFlagImageURL);
    }
}
