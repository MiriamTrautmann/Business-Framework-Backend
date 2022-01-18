package com.businessworkframe.db.financials;

import com.businessworkframe.pages.dashboard.InvoiceDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

public interface InvoiceDB {

    InvoiceDisplay getInvoiceDisplay() throws UnirestException, UnsupportedEncodingException;
}
