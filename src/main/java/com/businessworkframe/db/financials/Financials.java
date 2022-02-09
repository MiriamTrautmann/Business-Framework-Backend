package com.businessworkframe.db.financials;

import com.businessworkframe.db.dbDAOs.SalesAndEarningsDAO;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

/**
 * Java-Interface, das die Methoden für den Datenaustausch mit der Sales&Earning-Datenbanktabelle definiert.
 */
public interface Financials {
    SalesAndEarningsDAO[] getSalesAndEarnings(String startDate, String endDate) throws UnirestException, UnsupportedEncodingException;
}
