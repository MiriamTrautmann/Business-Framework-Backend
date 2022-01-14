package com.businessworkframe.db.financials;

import com.businessworkframe.db.dbDAOs.SalesAndEarningsDAO;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

public interface Financials {
    public SalesAndEarningsDAO[] getSalesAndEarnings(String startDate, String endDate) throws UnirestException, UnsupportedEncodingException;
}
