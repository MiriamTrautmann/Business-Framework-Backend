package com.businessframework.db.crm;

import com.businessframework.config.ObjectMapperConfig;
import com.businessframework.pages.dashboard.NewCostumerDisplay;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Java-Klasse, die Methoden zur Kundendarstellung liefert. Führt den Datenverkehr mit der CRM-Datenbanktabelle aus
 * sowie die Logik des JSON-Parsings.
 */
public class CRMDbImpl implements CRMDb {

    /**
     * Die URL zur CRM-Datenbanktabelle wird als Konstante festgelegt, sowie der API-Key.
     */
    private final String URL = "https://projektskizze-a175.restdb.io/rest/crm-1";
    private final String XAPIKEY= "61c3445da7907613a1abfd78" ;

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
    public CRMDbImpl() {
        objectMapperConfig.configObjectMapper();
    }

    /**
     * Methode, die Kunden-Informationen über den Zuwachs neuer Kunden an die Datenbank abfragt.
     * targetArchivement: Das Ziel des Unternehmens ist ein Zuwachs von 10 neue Kunden im Jahr.
     *
     * @return newCustomerDisplay: Informationsstruktur
     * @see NewCostumerDisplay
     * @throws UnirestException
     * @throws UnsupportedEncodingException
     */
    @Override
    public NewCostumerDisplay getNewCostumerDisplay() throws UnirestException, UnsupportedEncodingException {
        LocalDateTime now = LocalDateTime.now();
        NewCostumerDisplay newCostumerDisplay = new NewCostumerDisplay();
        String s = Unirest.get(URL+"?q="+ URLEncoder.encode("{\"creation_date\":{\"$gt\":{\"$date\":\""+now.getYear()+"-01-01"+
                        "\"},\"$lt\":{\"$date\":\""+now+"\"}}}", "UTF-8") +"&h=" +
                        URLEncoder.encode("{\"$aggregate\":[\"COUNT:creation_date\"]}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asString().getBody();
        System.out.println("Log: ausgeführte URL --> " +URL+"?q="+ "{\"creation_date\":{\"$gt\":{\"$date\":\""+now.getYear()+"-01-01"+"\"},\"$lt\":" +
                "{\"$date\":\""+now+"\"}}}&h={\"$aggregate\":[\"COUNT:creation_date\"]}");
        s= s.replace("{\"COUNT creation_date\":", "");
        s =s.replace("}","");
        int newCustomerNumber=Integer.parseInt(s);
        newCostumerDisplay.setNewCostumerNumber(Integer.parseInt(s));

        newCostumerDisplay.setTargetAchievement((double) newCustomerNumber/10*100);

        //Anzeige der neuen Kunden pro Monat für einen festgelegten Zeitraum

        HashMap costumerIncrease = Unirest.get(URL+"?h="+ URLEncoder.encode("{\"$groupby\":[\"$MONTH:creation_date\"], \"$aggregate\": [\"COUNT:name\"]}", "UTF-8") +"&q=" +
                        URLEncoder.encode("{\"creation_date\":{\"$gte\":{\"$date\":\""+now.getYear()+"-01-01"+"\"},\"$lt\":{\"$date\":\""+now+"\"}}}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(HashMap.class).getBody();
        System.out.println("Log: ausgeführte URL --> " +URL+"?h="+ "{\"$groupby\":[\"$MONTH:creation_date\"], \"$aggregate\": [\"COUNT:name\"]}" +"&q=" +
                "{\"creation_date\":{\"$gte\":{\"$date\":\""+now.getYear()+"-01-01"+"\"},\"$lt\":{\"$date\":\""+now+"\"}}}");

        //HashMap ummappen
        costumerIncrease.forEach((k,v)-> {
            int costumerIncreaseNumber = Integer.parseInt(v.toString().replace("{COUNT name=", "").replace("}",""));
            costumerIncrease.put(k,costumerIncreaseNumber);
        });

        newCostumerDisplay.setCustomerIncrease(costumerIncrease);
        return newCostumerDisplay;
    }
}
