package com.businessworkframe.db.user;

import com.businessworkframe.model.User;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

/**
 * Java-Interface, das die Methoden für die Authentifizierung und Autorisierung definiert.
 */
public interface Login {

    Auth login(User user) throws UnsupportedEncodingException, UnirestException;
    Boolean logout(Auth auth) throws UnirestException;
    Boolean isAuthorized(Auth auth) throws UnsupportedEncodingException, UnirestException;

}
