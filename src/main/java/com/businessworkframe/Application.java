package com.businessworkframe;

import com.businessworkframe.db.financials.FinancialsImpl;
import com.businessworkframe.db.dbDAOs.SalesAndEarningsDAO;
import com.businessworkframe.db.user.Auth;
import com.businessworkframe.db.user.Login;
import com.businessworkframe.db.user.LoginImpl;
import com.businessworkframe.model.User;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main (String[] args) throws UnirestException, UnsupportedEncodingException {
        SpringApplication.run(Application.class, args);

        /*BPDbImpl bpDb = new BPDbImpl();
        BusinessPartner[] bp = bpDb.getBusinessPartner(116);
        System.out.println(bp[0].getBp_street());

        BusinessPartner[] allBp = bpDb.getAllBusinessPartner();
        for(BusinessPartner b : allBp){
            System.out.println(b.getBp_name());
        }
        System.out.println(allBp.length);*/

        FinancialsImpl fDb = new FinancialsImpl();

        Date startDate = new Date();
        startDate.setMonth(Calendar.JANUARY);
        startDate.setYear(2016);
        Date endDate = new Date();
        endDate.setMonth(Calendar.JANUARY);
        endDate.setYear(2018);

        System.out.println(startDate);
        System.out.println(endDate);
        SalesAndEarningsDAO[] f = fDb.getSalesAndEarnings( "2015-01-31", "2016-01-31");
        for(SalesAndEarningsDAO s : f){
            System.out.println(s.getDate());
        }
    }
}
