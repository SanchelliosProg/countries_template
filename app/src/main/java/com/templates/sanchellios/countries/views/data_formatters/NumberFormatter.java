package com.templates.sanchellios.countries.views.data_formatters;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by aleksandrvasilenko on 10.05.16.
 */
public class NumberFormatter {
    public static String separateByComma(long population){
        BigDecimal decimal = new BigDecimal(population);
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        return String.valueOf(formatter.format(decimal.longValue()));
    }
}
