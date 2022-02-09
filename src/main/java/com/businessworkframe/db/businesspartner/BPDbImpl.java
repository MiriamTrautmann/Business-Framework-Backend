package com.businessworkframe.db.businesspartner;

import com.businessworkframe.config.ObjectMapperConfig;
import com.businessworkframe.db.dbDAOs.BusinessPartnerDAO;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Java-Klasse, die Methoden zur BusinessPartner-Darstellung liefert. Führt den Datenverkehr mit der Business-Partner-
 * Datenbanktabelle sowie die Logik des JSON-Parsings aus.
 */
public class BPDbImpl implements BPDb {

    /**
     * Die URL zur Business-Partner-Datenbanktabelle wird als Konstante festgelegt, sowie der API-Key.
     */
    private final String URL = "https://projektskizze-a175.restdb.io/rest/business-partner";
    private final String XAPIKEY = "61c3445da7907613a1abfd78";

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();

    public BPDbImpl() {
        objectMapperConfig.configObjectMapper();
    }

    /**
     * Methode, die einen einzelnen Business-Partner in der Datenbank abfragt.
     *
     * @param bp_id eindeutige Business-Partner-Id
     * @return BusinessPartnerDAO-Klasse als Datenbank-Informationsstrukturobjekt
     * @see BusinessPartnerDAO
     * @throws UnirestException
     * @throws UnsupportedEncodingException
     */
    @Override
    public BusinessPartnerDAO[] getBusinessPartner(int bp_id) throws UnirestException, UnsupportedEncodingException {
        JSONObject jsonQuery = new JSONObject();
        jsonQuery.put("bp_id", bp_id);
        String query = jsonQuery.toJSONString();

        System.out.println("Log: ausgeführte URL --> " + URL + "?q=" + URLEncoder.encode(query, "UTF-8"));

        return Unirest.get(URL + URLEncoder.encode(query, "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(BusinessPartnerDAO[].class).getBody();
    }

    /**
     * Methode, die alle Business-Partner in der Datenbank abfragt.
     * @return BusinessPartnerDAO[] Array aus allen Business-Partner-Objekten
     * @throws UnirestException
     */
    @Override
    public BusinessPartnerDAO[] getAllBusinessPartner() throws UnirestException {
        System.out.println("Log: ausgeführte URL --> " + URL);
        return Unirest.get(URL)
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(BusinessPartnerDAO[].class).getBody();
    }

}
