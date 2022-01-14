package com.businessworkframe.db.businesspartner;

import com.businessworkframe.model.BusinessPartner;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BPDbImpl implements BPDb{

    private final String URL = "https://projektskizze-a175.restdb.io/rest/business-partner?q=";
    private final String XAPIKEY= "eaabcde666d8b00aa3ebf7e2c58aa29cfb44d" ;

    @Override
    public BusinessPartner[] getBusinessPartner(int bp_id) throws UnirestException, UnsupportedEncodingException {
        JSONObject jsonQuery = new JSONObject();
        jsonQuery.put("bp_id", bp_id);
        String query =  jsonQuery.toJSONString();

        System.out.println("Log: ausgeführte URL --> " +URL + URLEncoder.encode(query, "UTF-8"));

        return Unirest.get(URL + URLEncoder.encode(query, "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(BusinessPartner[].class).getBody();
    }

    @Override
    public BusinessPartner[] getAllBusinessPartner() throws UnirestException {
        return Unirest.get("https://projektskizze-a175.restdb.io/rest/business-partner")
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(BusinessPartner[].class).getBody();
    }

    /*
    String methodURL2 = URLEncoder.encode("?q={\"bp_id\":"+ bp_id + "}","UTF-8");
        String URL2 = "https://projektskizze-a175.restdb.io/rest/business-partner?q=%7B/%22bp_contract_status/%22:/%22inactive/%22,/%22bp_id/%22:122%7D";
     */
}
