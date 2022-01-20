package com.businessworkframe.db.employee;

import com.businessworkframe.config.ObjectMapperConfig;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;

public class EmployeeImpl implements EmployeeDb {
    private final String URL = "https://projektskizze-a175.restdb.io/rest/employee";
    private final String XAPIKEY= "61c3445da7907613a1abfd78" ;

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
    public EmployeeImpl() {
        objectMapperConfig.configObjectMapper();
    }


    @Override
    public HashMap getEmmployeePerApartment() throws UnirestException {

        HashMap employeeIncrease =  Unirest.get(URL)
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(HashMap.class).getBody();

        
        return null;
    }
}
