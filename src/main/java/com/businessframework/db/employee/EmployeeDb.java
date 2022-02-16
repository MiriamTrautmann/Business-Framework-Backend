package com.businessframework.db.employee;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Java-Interface, das die Methoden für den Datenaustausch mit der Employee-Datenbanktabelle definiert.
 */
public interface EmployeeDb {
    HashMap getEmployeePerApartment() throws UnirestException, UnsupportedEncodingException;
}
