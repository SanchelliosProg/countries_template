package com.templates.sanchellios.countries.data.database;

import com.templates.sanchellios.countries.country.ContinentConst;
import com.templates.sanchellios.countries.country.Country;

import java.util.ArrayList;

/**
 * Created by aleksandrvasilenko on 11.05.16.
 */
public class DefaultData {
    public static ArrayList<Country> getDefaultData(){
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

        country = new Country("France", 66660000, 2.647, ContinentConst.EUROPE);
        country.addInternetResources(
                "https://en.wikipedia.org/wiki/France",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Armoiries_république_française.svg/2000px-Armoiries_république_française.svg.png",
                "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1280px-Flag_of_France.svg.png"
        );
        countries.add(country);

        country = new Country("Japan", 126919659, 4.116, ContinentConst.ASIA);
        country.addInternetResources(
                "https://en.wikipedia.org/wiki/Japan",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Imperial_Seal_of_Japan.svg/2000px-Imperial_Seal_of_Japan.svg.png",
                "https://upload.wikimedia.org/wikipedia/en/c/c1/Flag_of_Japan_(bordered).PNG"
        );
        countries.add(country);

        country = new Country("Canada", 36048521, 1.628, ContinentConst.NORTH_AMERICA);
        country.addInternetResources(
                "https://en.wikipedia.org/wiki/Canada",
                "https://upload.wikimedia.org/wikipedia/en/thumb/4/4f/Coat_of_arms_of_Canada.svg/245px-Coat_of_arms_of_Canada.svg.png",
                "https://upload.wikimedia.org/wikipedia/en/thumb/c/cf/Flag_of_Canada.svg/1280px-Flag_of_Canada.svg.png");
        countries.add(country);

        country = new Country("Argentina", 43417000, 0.578, ContinentConst.SOUTH_AMERICA);
        country.addInternetResources("https://en.wikipedia.org/wiki/Argentina",
                "http://www.ngw.nl/heraldrywiki/images/thumb/7/7c/Argentina.jpg/400px-Argentina.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/2000px-Flag_of_Argentina.svg.png");
        countries.add(country);

        country = new Country("Egypt", 90928000, 0.989, ContinentConst.AFRICA);
        country.addInternetResources(
                "https://en.wikipedia.org/wiki/Egypt",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Coat_of_arms_of_Egypt_(Official).svg/2000px-Coat_of_arms_of_Egypt_(Official).svg.png",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/2000px-Flag_of_Egypt.svg.png");
        countries.add(country);

        country = new Country("New Zealand", 4686930, 0.173, ContinentConst.AUSTRALIA_AND_OCEANIA);
        country.addInternetResources("https://en.wikipedia.org/wiki/New_Zealand",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Coat_of_arms_of_New_Zealand.svg/2000px-Coat_of_arms_of_New_Zealand.svg.png",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Flag_of_New_Zealand.svg/2000px-Flag_of_New_Zealand.svg.png");
        countries.add(country);

        country = new Country("Spain", 46423064, 1.636, ContinentConst.EUROPE);
        country.addInternetResources("https://en.wikipedia.org/wiki/Spain",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Coat_of_Arms_of_Spain_(corrections_of_heraldist_requests).svg/2000px-Coat_of_Arms_of_Spain_(corrections_of_heraldist_requests).svg.png",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9a/Flag_of_Spain.svg/1280px-Flag_of_Spain.svg.png");
        countries.add(country);

        country = new Country("Nigeria", 182202000, 1.166, ContinentConst.AFRICA);
        country.addInternetResources("https://en.wikipedia.org/wiki/Nigeria",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Coat_of_arms_of_Nigeria.svg/2000px-Coat_of_arms_of_Nigeria.svg.png",
                "http://www.crwflags.com/fotw/images/n/ng.gif");
        countries.add(country);

        country = new Country("India", 1276267000, 8.027, ContinentConst.ASIA);
        country.addInternetResources("https://en.wikipedia.org/wiki/India",
                "http://previews.123rf.com/images/perysty/perysty1201/perysty120100042/11751350-Coat-of-arms-of-India-Stock-Vector-india-emblem.jpg",
                "http://www.mapsofindia.com/maps/india/india-flag-a4.jpg");
        countries.add(country);

        country = new Country("England", 54316600, 2.68, ContinentConst.EUROPE);
        country.addInternetResources("https://en.wikipedia.org/wiki/England",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Royal_Coat_of_Arms_of_the_United_Kingdom.svg/2000px-Royal_Coat_of_Arms_of_the_United_Kingdom.svg.png",
                "https://upload.wikimedia.org/wikipedia/en/thumb/b/be/Flag_of_England.svg/1280px-Flag_of_England.svg.png");
        countries.add(country);

        return countries;
    }
}
