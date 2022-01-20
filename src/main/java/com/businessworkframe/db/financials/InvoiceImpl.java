package com.businessworkframe.db.financials;

import com.businessworkframe.config.ObjectMapperConfig;
import com.businessworkframe.db.dbDAOs.InvoiceDAO;
import com.businessworkframe.db.dbDAOs.TicketDAO;
import com.businessworkframe.pages.dashboard.InvoiceDisplay;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;

public class InvoiceImpl  implements InvoiceDB{

    private final String URL = "https://projektskizze-a175.restdb.io/rest/invoice";
    private final String XAPIKEY= "61c3445da7907613a1abfd78" ;

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
    public InvoiceImpl() {
        objectMapperConfig.configObjectMapper();
    }

    @Override
    public InvoiceDisplay getInvoiceDisplay() throws UnirestException, UnsupportedEncodingException {
        LocalDateTime now = LocalDateTime.now();
        InvoiceDAO[] invoiceDAOS = Unirest.get(URL+"?q="+URLEncoder.encode("{\"invoice_date\":{\"$gt\":{\"$date\":\""+now.getYear()+"-01-01"+
                "\"},\"$lt\":{\"$date\":\""+now+"\"}}}", StandardCharsets.UTF_8))
                .header("x-apikey", "eaabcde666d8b00aa3ebf7e2c58aa29cfb44d")
                .header("cache-control", "no-cache")
                .asObject(InvoiceDAO[].class).getBody();

        System.out.println(URL+"?q="+"{\"invoice_date\":{\"$gt\":{\"$date\":\""+now.getYear()+"-01-01"+
                "\"},\"$lt\":{\"$date\":\""+now+"\"}}}" +"&h=" +
               "{\"$aggregate\":[\"COUNT:invoice_date\"]}");

        HashMap invoiceIncrease = new HashMap<>();

        String dateLastYear = now.minusMonths(12).getYear()+"/"+now.minusMonths(12).getMonth()+"/01";
        InvoiceDAO[] invoicesLastYear = Unirest.get(URL+ "?q="+ URLEncoder.encode("{\"invoice_date\":{\"$gte\":{\"$date\":\""+dateLastYear+"\"}, " +
                        "\"$lte\":{\"$date\":\""+now+"\"}}}", StandardCharsets.UTF_8))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(InvoiceDAO[].class).getBody();

        for(InvoiceDAO i: invoicesLastYear ){
            LocalDate getLocalDate = i.getInvoice_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String key = getLocalDate.getYear()+"/"+ getLocalDate.getMonthValue();
            if(invoiceIncrease.get(key)==null){
                invoiceIncrease.put(key,1 );
            }else{
                int counter = (int) invoiceIncrease.get(key);
                invoiceIncrease.put(key, ++counter);
            }

        }

        return new InvoiceDisplay(invoiceDAOS.length, (double)invoiceDAOS.length/750*100, invoiceIncrease);

    }
}