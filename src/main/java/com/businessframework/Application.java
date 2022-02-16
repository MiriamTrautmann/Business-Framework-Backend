package com.businessframework;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;

/**
 * Die Application-Klasse führt die Spring-Application und somit die REST-API aus.
 * Über die Spring-Application können die Schnittstellen aus dem Mapping-Controller aufgerufen werden.
 *
 * @see MappingController
 */
@SpringBootApplication
public class Application {

    public static void main (String[] args) throws UnirestException, UnsupportedEncodingException {
        SpringApplication.run(Application.class, args);


    }
}
