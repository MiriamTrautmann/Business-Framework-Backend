package com.businessworkframe.db.employee;

import com.businessworkframe.model.Employee;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public interface EmployeeDb {
    HashMap getEmmployeePerApartment() throws UnirestException, UnsupportedEncodingException;
}
