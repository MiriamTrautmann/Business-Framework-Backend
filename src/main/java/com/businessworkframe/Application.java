package com.businessworkframe;

import com.businessworkframe.db.crm.CRMDb;
import com.businessworkframe.db.crm.CRMDbImpl;
import com.businessworkframe.db.financials.FinancialsImpl;
import com.businessworkframe.db.dbDAOs.SalesAndEarningsDAO;
import com.businessworkframe.db.financials.InvoiceDB;
import com.businessworkframe.db.financials.InvoiceImpl;
import com.businessworkframe.db.tickets.TicketDb;
import com.businessworkframe.db.tickets.TicketDbImpl;
import com.businessworkframe.db.user.Auth;
import com.businessworkframe.db.user.Login;
import com.businessworkframe.db.user.LoginImpl;
import com.businessworkframe.model.User;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;


@SpringBootApplication
public class Application {

    public static void main (String[] args) throws UnirestException, UnsupportedEncodingException {
        SpringApplication.run(Application.class, args);

        FinancialsImpl fDb = new FinancialsImpl();

        CRMDb crmDb = new CRMDbImpl();

        TicketDb ticketDb = new TicketDbImpl();

        InvoiceDB invoiceDB = new InvoiceImpl();

        invoiceDB.getInvoiceDisplay();

    }
}
