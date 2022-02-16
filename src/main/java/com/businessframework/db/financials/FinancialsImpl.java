package com.businessframework.db.financials;

import com.businessframework.config.ObjectMapperConfig;
import com.businessframework.db.dbDAOs.SalesAndEarningsDAO;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Java-Klasse, die Methoden über Finanzen liefert. Führt den Datenverkehr mit der Sales&Earning-Datenbanktabelle aus.
 */
public class FinancialsImpl implements Financials{

    /**
     * Die URL zur Sales&Earning-Datenbanktabelle wird als Konstante festgelegt, sowie der API-Key.
     */
    private final String URL = "https://projektskizze-a175.restdb.io/rest/sales-earnings";
    private final String XAPIKEY = "61c3445da7907613a1abfd78";

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
    public FinancialsImpl() {
        objectMapperConfig.configObjectMapper();
    }

    @Override
    public SalesAndEarningsDAO[] getSalesAndEarnings(String startDate, String endDate) throws UnirestException, UnsupportedEncodingException {
        String query = "{\"date\":{\"$gt\":{\"$date\":\""+startDate+"\"},\"$lt\":{\"$date\":\""+endDate+"\"}}}";
        System.out.println("Log: ausgeführte URL --> " +URL+"?q="+query);
        return Unirest.get(URL+ "?q="+ URLEncoder.encode(query, "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(SalesAndEarningsDAO[].class).getBody();
    }
}
