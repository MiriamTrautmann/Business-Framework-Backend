package com.businessworkframe.db.employee;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;

public interface EmployeeDb {
    HashMap getEmmployeePerApartment() throws UnirestException;
}
