package com.templates.sanchellios.countries.views.data_formatters;

/**
 * Created by aleksandrvasilenko on 10.05.16.
 */
public class GdpDimension {
    public static String defineDimension(double gdp){
        if(gdp >= 1){
            return "$"+String.valueOf(gdp)+" trillion";
        }else {
            return "$"+String.valueOf(gdp * 1000) + " billion";
        }
    }
}
