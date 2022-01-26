package com.businessworkframe.db.businesspartner;

import com.businessworkframe.db.dbDAOs.BusinessPartnerDAO;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

public interface BPDb {
    BusinessPartnerDAO[] getBusinessPartner(int bp_id) throws UnirestException, UnsupportedEncodingException;
    BusinessPartnerDAO[] getAllBusinessPartner() throws UnirestException;

}
