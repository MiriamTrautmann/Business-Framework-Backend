package com.businessworkframe.db.crm;

import com.businessworkframe.config.ObjectMapperConfig;
import com.businessworkframe.pages.dashboard.NewCostumerDisplay;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CRMDbImpl implements CRMDb {
    private final String URL = "https://projektskizze-a175.restdb.io/rest/crm-1";
    private final String XAPIKEY= "61c3445da7907613a1abfd78" ;

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
    public CRMDbImpl() {
        objectMapperConfig.configObjectMapper();
    }

    @Override
    public NewCostumerDisplay getNewCostumerDisplay(String startDisplay, String endDisplay) throws UnirestException, UnsupportedEncodingException {
        LocalDateTime now = LocalDateTime.now();
        NewCostumerDisplay newCostumerDisplay = new NewCostumerDisplay();
        String s = Unirest.get(URL+"?q="+ URLEncoder.encode("{\"creation_date\":{\"$gt\":{\"$date\":\""+now.getYear()+"-01-01"+
                        "\"},\"$lt\":{\"$date\":\""+now+"\"}}}", "UTF-8") +"&h=" +
                        URLEncoder.encode("{\"$aggregate\":[\"COUNT:creation_date\"]}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asString().getBody();
        System.out.println(URL+"?q="+ "{\"creation_date\":{\"$gt\":{\"$date\":\""+now.getYear()+"-01-01"+"\"},\"$lt\":" +
                "{\"$date\":\""+now+"\"}}}&h={\"$aggregate\":[\"COUNT:creation_date\"]}");
        s= s.replace("{\"COUNT creation_date\":", "");
        s =s.replace("}","");
        int newCustomerNumber=Integer.parseInt(s);
        newCostumerDisplay.setNewCostumerNumber(Integer.parseInt(s));

        //Ziel: 10 neue Kunden pro Jahr --> Prozentzahl
        newCostumerDisplay.setTargetAchievement((double) newCustomerNumber/10*100);

        //Anzeige der neuen Kunden pro Monat für einen festgelegten Zeitraum

        HashMap costumerIncrease = Unirest.get(URL+"?h="+ URLEncoder.encode("{\"$groupby\":[\"$MONTH:creation_date\"], \"$aggregate\": [\"COUNT:name\"]}", "UTF-8") +"&q=" +
                        URLEncoder.encode("{\"creation_date\":{\"$gte\":{\"$date\":\""+startDisplay+"\"},\"$lt\":{\"$date\":\""+endDisplay+"\"}}}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(HashMap.class).getBody();
        //HashMap ummappen
        costumerIncrease.forEach((k,v)-> {
            int costumerIncreaseNumber = Integer.parseInt(v.toString().replace("{COUNT name=", "").replace("}",""));
            costumerIncrease.put(k,costumerIncreaseNumber);
        });

        newCostumerDisplay.setCustomerIncrease(costumerIncrease);
        return newCostumerDisplay;
    }
}
