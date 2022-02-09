package com.businessworkframe.db.financials;

import com.businessworkframe.pages.dashboard.InvoiceDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

/**
 * Java-Interface, das die Methoden für den Datenaustausch mit der Invoice-Datenbanktabelle definiert.
 */
public interface InvoiceDB {
    InvoiceDisplay getInvoiceDisplay() throws UnirestException, UnsupportedEncodingException;
}
