package com.businessworkframe.db.businesspartner;

import com.businessworkframe.model.BusinessPartner;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

public interface BPDb {
    BusinessPartner[] getBusinessPartner(int bp_id) throws UnirestException, UnsupportedEncodingException;
    BusinessPartner[] getAllBusinessPartner() throws UnirestException;

}
