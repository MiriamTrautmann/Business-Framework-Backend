package com.businessworkframe.db.businesspartner;

import com.businessworkframe.db.dbDAOs.BusinessPartnerDAO;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

/**
 * Java-Interface, das die Methoden für den Datenaustausch mit der BusinessPartner-Datenbanktabelle definiert.
 * Wird für den derzeitiegen Prototyp-Stand (09.02.2022) nicht verwendet.
 *
 */
public interface BPDb {
    BusinessPartnerDAO[] getBusinessPartner(int bp_id) throws UnirestException, UnsupportedEncodingException;
    BusinessPartnerDAO[] getAllBusinessPartner() throws UnirestException;

}
