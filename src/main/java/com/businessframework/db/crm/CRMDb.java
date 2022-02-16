package com.businessframework.db.crm;

import com.businessframework.pages.dashboard.NewCostumerDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

/**
 * Java-Interface, das die Methoden für den Datenaustausch mit der CRM-Datenbanktabelle definiert.
 */
public interface CRMDb {
    NewCostumerDisplay getNewCostumerDisplay() throws UnirestException, UnsupportedEncodingException;
}
