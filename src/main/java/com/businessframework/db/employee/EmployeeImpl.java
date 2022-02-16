package com.businessframework.db.employee;

import com.businessframework.config.ObjectMapperConfig;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Java-Klasse, die Methoden über die Mitarbeiter liefert. Führt den Datenverkehr mit der Employee-Datenbanktabelle
 * sowie die Logik des JSON-Parsings aus.
 */
public class EmployeeImpl implements EmployeeDb {

    /**
     * Die URL zur Employee-Datenbanktabelle wird als Konstante festgelegt, sowie der API-Key.
     */
    private final String URL = "https://projektskizze-a175.restdb.io/rest/employee";
    private final String XAPIKEY = "61c3445da7907613a1abfd78";

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();

    public EmployeeImpl() {
        objectMapperConfig.configObjectMapper();
    }

    /**
     * Methode, die die Daten(struktur) für den Mitarbeiteranstieg pro Abteilung übergibt.
     *
     * @return HashMap: Informationsstruktur
     * @throws UnirestException
     */
    @Override
    public HashMap getEmployeePerApartment() throws UnirestException {
        LocalDateTime now = LocalDateTime.now();

        HashMap employeeBasis = Unirest.get(URL + "?q=" + URLEncoder.encode("{\"entry_date\":{\"$lt\":{\"$date\":\"" + now.minusYears(8).getYear() + "/JANUARY/01\"}}}",
                        StandardCharsets.UTF_8) + "&h=" + URLEncoder.encode("{\"$groupby\":[\"department\"],\"$aggregate\":[\"COUNT:entry_date\"]}",
                        StandardCharsets.UTF_8))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(HashMap.class).getBody();

        System.out.println("Log: ausgeführte URL --> "+URL + "?q=" + "{\"entry_date\":{\"$lt\":{\"$date\":\"" + now.minusYears(8).getYear() + "/JANUARY/01\"}}}" + "&h=" +
                "{\"$groupby\":[\"department\"],\"$aggregate\":[\"COUNT:entry_date\"]}");
        HashMap<String, HashMap> employeeIncrease = Unirest.get(URL + "?h=" + URLEncoder.encode("{\"$groupby\":[ \"department\",\"$YEAR:entry_date\"],\"$aggregate\":[\"COUNT:entry_date\"]}",
                        StandardCharsets.UTF_8) + "&q=" + URLEncoder.encode("{\"entry_date\":{\"$gte\":{\"$date\":\"" + now.minusYears(8).getYear() + "/JANUARY/01\"}}}",
                        StandardCharsets.UTF_8))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(HashMap.class).getBody();

        System.out.println("Log: ausgeführte URL --> " +URL + "?h=" + "{\"$groupby\":[ \"department\",\"$YEAR:entry_date\"],\"$aggregate\":[\"COUNT:entry_date\"]}"
                + "&q=" + "{\"entry_date\":{\"$gte\":{\"$date\":\"" + now.minusYears(8).getYear() + "/JANUARY/01\"}}}");


        employeeBasis.forEach((k, v) -> {
            String s = v.toString().replace("{COUNT entry_date=", "");
            s = s.replace("}", "");
            int basisYearNumber = Integer.parseInt(s);
            int[] cache = {basisYearNumber};
            //int[] year8YearsAgo = {now.minusYears(8).getYear()};

            employeeIncrease.forEach((department, yearsMap) -> {
                if (department.equals(k)) {
                    cache[0] = basisYearNumber;
                    System.out.println("Department: " + k);
                    yearsMap.forEach((year, counterYear) -> {
                        String z = counterYear.toString().replace("{COUNT entry_date=", "");
                        z = z.replace("}", "");
                        int numberPerYear = Integer.parseInt(z);

                        yearsMap.put(year, cache[0] + numberPerYear);
                        cache[0] = cache[0] + numberPerYear;

                    });

                    //Zukünftige Aufgabe

                    //Füllen mit den Jahren dazwischen
                        /*int[] valueBefore = {0};
                        yearsMap.forEach((y,n)->{
                            if(year8YearsAgo[0]<now.getYear()){

                            if(year8YearsAgo[0] == Integer.parseInt(y.toString())){
                                year8YearsAgo[0]++;
                                valueBefore[0] = Integer.parseInt(n.toString());
                            }else{
                                    yearsMap.put(year8YearsAgo[0]++, valueBefore[0]);
                            }}

                            System.out.println("Jahr: "+y);
                            System.out.println("Anzahl Mitarbeiter: "+n);
                        });*/
                }

            });

        });

        return employeeIncrease;
    }
}
