package com.businessworkframe.db.crm;

import com.businessworkframe.pages.dashboard.NewCostumerDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

public interface CRMDb {
    NewCostumerDisplay getNewCostumerDisplay(String startDisplay, String endDisplay) throws UnirestException, UnsupportedEncodingException;
}
