package com.businessworkframe.db.tickets;

import com.businessworkframe.config.ObjectMapperConfig;
import com.businessworkframe.db.dbDAOs.TicketDAO;
import com.businessworkframe.pages.dashboard.TicketDisplay;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TicketDbImpl implements TicketDb {
    private final String URL = "https://projektskizze-a175.restdb.io/rest/tickets";
    private final String XAPIKEY= "61c3445da7907613a1abfd78" ;

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
    public TicketDbImpl() {
        objectMapperConfig.configObjectMapper();
    }

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
            //System.out.println("Creation date: "+ t.getCreation_date());
            //System.out.println(dayDiff);
            //System.out.println("Close date: "+ t.getClose_date());
        }
        ticketDisplay.setTicketTimeAvg((int)total/count);

        ticketDisplay.setTargetAchievement((double)((int)total/count)/2*100);
        System.out.println(ticketDisplay.getTargetAchievement());
        LocalDateTime now = LocalDateTime.now();
        //now.minusMonths()
        TicketDAO[] ticketDAOLastYear = Unirest.get(URL+ "?q="+ URLEncoder.encode("{\"creation_date\":{\"$gte\":{\"$date\":\""+ now+"\"}, " +
                        "\"$lt\":{\"$date\":\"2022-01-01\"}}, \"close_date\":{\"$gte\":{\"$date\":\"2021-01-01\"}, " +
                        "\"$lt\":{\"$date\":\"2022-01-01\"}}}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(TicketDAO[].class).getBody();


        return null;
    }
}
