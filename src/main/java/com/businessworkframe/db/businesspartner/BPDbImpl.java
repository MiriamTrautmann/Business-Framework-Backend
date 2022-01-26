package com.businessworkframe.db.businesspartner;

import com.businessworkframe.config.ObjectMapperConfig;
import com.businessworkframe.db.dbDAOs.BusinessPartnerDAO;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BPDbImpl implements BPDb {

    private final String URL = "https://projektskizze-a175.restdb.io/rest/business-partner";
    private final String XAPIKEY = "61c3445da7907613a1abfd78";

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();

    public BPDbImpl() {
        objectMapperConfig.configObjectMapper();
    }

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

    @Override
    public BusinessPartnerDAO[] getAllBusinessPartner() throws UnirestException {
        return Unirest.get(URL)
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(BusinessPartnerDAO[].class).getBody();
    }


}
