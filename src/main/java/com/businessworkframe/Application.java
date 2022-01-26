package com.businessworkframe;

import com.businessworkframe.db.crm.CRMDb;
import com.businessworkframe.db.crm.CRMDbImpl;
import com.businessworkframe.db.employee.EmployeeDb;
import com.businessworkframe.db.employee.EmployeeImpl;
import com.businessworkframe.db.financials.FinancialsImpl;
import com.businessworkframe.db.financials.InvoiceDB;
import com.businessworkframe.db.financials.InvoiceImpl;
import com.businessworkframe.db.tickets.TicketDb;
import com.businessworkframe.db.tickets.TicketDbImpl;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;

/**
 * Die Application-Klasse führt die Spring-Application und somit die REST-API aus.
 * Über die Spring-Application können die Schnittstellen aus dem Mapping-Controller aufgerufen werden.
 *
 * @see MappingController
 */
@SpringBootApplication
public class Application {

    public static void main (String[] args) throws UnirestException, UnsupportedEncodingException {
        SpringApplication.run(Application.class, args);

        FinancialsImpl fDb = new FinancialsImpl();
        CRMDb crmDb = new CRMDbImpl();
        TicketDb ticketDb = new TicketDbImpl();
        InvoiceDB invoiceDB = new InvoiceImpl();
        EmployeeDb employeeDb = new EmployeeImpl();

        invoiceDB.getInvoiceDisplay();

        employeeDb.getEmmployeePerApartment();


    }
}
