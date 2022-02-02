package com.businessworkframe.db.tickets;

import com.businessworkframe.config.ObjectMapperConfig;
import com.businessworkframe.db.dbDAOs.TicketDAO;
import com.businessworkframe.pages.dashboard.TicketDisplay;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Java-Klasse, welche Methoden zur Ticketdarstellung liefert. Führt den Datenverkehr mit der Ticket-Datenbanktabelle aus
 * und führt die Logik des JSON-Parsings aus.
 */
public class TicketDbImpl implements TicketDb {

    /**
     * Die URL zur Ticket-Datenbanktabelle wird fest gesetzt, sowie der API-Key.
     */
    private final String URL = "https://projektskizze-a175.restdb.io/rest/tickets";
    private final String XAPIKEY= "61c3445da7907613a1abfd78" ;

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
    public TicketDbImpl() {
        objectMapperConfig.configObjectMapper();
    }

    /**
     * Methode, die durchschnittliche Ticket-Informationen an die Datenbank abfragt.
     *
     * @return TicketDisplay: Informationsstrukturobjekt
     * @see TicketDisplay
     * @throws UnsupportedEncodingException
     * @throws UnirestException
     */
    @Override
    public TicketDisplay getAvgTickets() throws UnsupportedEncodingException, UnirestException {

        TicketDisplay ticketDisplay = new TicketDisplay();

        TicketDAO[] ticketDAO= Unirest.get(URL+ "?q="+ URLEncoder.encode("{\"creation_date\":{\"$gte\":{\"$date\":\"2021-01-01\"}, " +
                        "\"$lt\":{\"$date\":\"2022-01-01\"}}, \"close_date\":{\"$gte\":{\"$date\":\"2021-01-01\"}, " +
                        "\"$lt\":{\"$date\":\"2022-01-01\"}}}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(TicketDAO[].class).getBody();
        int count = 0;
        long total=0;
        for (TicketDAO t : ticketDAO){
            long diffInMillies = Math.abs(t.getClose_date().getTime() - t.getCreation_date().getTime());
            long dayDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            total = total+dayDiff;
            ++count;
        }
        ticketDisplay.setTicketTime((int)total/count);

        ticketDisplay.setTargetAchievement((double)((int)total/count)/2*100);
        System.out.println(ticketDisplay.getTargetAchievement());
        LocalDateTime now = LocalDateTime.now();
        TicketDAO[] ticketDAOLastYear = Unirest.get(URL+ "?q="+ URLEncoder.encode("{\"close_date\":{\"$gte\":{\"$date\":\""+now.minusMonths(12)+"\"}, " +
                        "\"$lt\":{\"$date\":\""+now+"\"}}}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(TicketDAO[].class).getBody();

        System.out.println(URL+ "?q="+"{\"close_date\":{\"$gte\":{\"$date\":\""+now.minusMonths(12)+"\"}, " +
                "\"$lt\":{\"$date\":\""+now+"\"}}}");
        HashMap closedTicketIncrease = new HashMap<>();


        //Verbesserung: Nicht nur den Counter sondern den Durchschnitt ausgeben
        for(TicketDAO t: ticketDAOLastYear ){
            if(t.getCreation_date().getMonth()==t.getClose_date().getMonth()){

                LocalDate getLocalDate = t.getClose_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String key = getLocalDate.getYear()+"/"+t.getClose_date().getMonth();
                if(closedTicketIncrease.get(key)==null){
                    closedTicketIncrease.put(key,1 );
                }else{
                    int counter = (int) closedTicketIncrease.get(key);
                    closedTicketIncrease.put(key, ++counter);
                }
            }
        }
        ticketDisplay.setTicketCourse(closedTicketIncrease);
        return ticketDisplay;
    }

    /**
     *
     * @return
     * @throws UnsupportedEncodingException
     * @throws UnirestException
     */
    @Override
    public TicketDisplay getNewTickets() throws UnsupportedEncodingException, UnirestException {

        LocalDateTime now = LocalDateTime.now();
        String monthBegin = now.getYear()+"/"+now.getMonth().getValue()+"/01";
        TicketDAO[] ticketDAO= Unirest.get(URL+ "?q="+ URLEncoder.encode("{\"creation_date\":{\"$gte\":{\"$date\":\""+monthBegin+"\"}, " +
                        "\"$lte\":{\"$date\":\""+now+"\"}}}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(TicketDAO[].class).getBody();
        String dateSixMonthsAgo = now.minusMonths(6).getYear()+"/"+now.minusMonths(6).getMonth()+"/01";
        TicketDAO[] ticketLastSixMonths = Unirest.get(URL+ "?q="+ URLEncoder.encode("{\"creation_date\":{\"$gte\":{\"$date\":\""+dateSixMonthsAgo+"\"}, " +
                        "\"$lte\":{\"$date\":\""+now+"\"}}}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(TicketDAO[].class).getBody();

        HashMap openTicketIncrease = new HashMap<>();

        for(TicketDAO t: ticketLastSixMonths ){
                LocalDate getLocalDate = t.getCreation_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String key = getLocalDate.getYear()+"/"+ getLocalDate.getMonthValue();
                if(openTicketIncrease.get(key)==null){
                    openTicketIncrease.put(key,1 );
                }else{
                    int counter = (int) openTicketIncrease.get(key);
                    openTicketIncrease.put(key, ++counter);
                }

        }


         return new TicketDisplay(ticketDAO.length, (double)ticketDAO.length/15*100, openTicketIncrease);
    }


}
