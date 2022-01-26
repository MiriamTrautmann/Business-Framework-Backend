package com.businessworkframe.db.user;

import com.businessworkframe.db.dbDAOs.UserResponseDAO;
import com.businessworkframe.model.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Java-Klasse, welche das Login-Interface integriert. Führt den Datenverkehr mit der User-Datenbanktabelle aus und
 * führt die Logik des JSON-Parsings aus.
 */
public class LoginImpl implements  Login {

    /**
     * Die URL zur User-Datenbanktabelle wird fest gesetzt, sowie der API-Key.
     */
    private final String URL = "https://projektskizze-a175.restdb.io/rest/app-user";
    private final String XAPIKEY= "61c3445da7907613a1abfd78" ;

    /**
     * Methode, die die User-Informationen an die Datenbank abfragt.
     *
     * @param user User-Informationen bestehend aus E-Mail und Passwort
     * @see User
     * @return Authentifizierungsobjekt mit einem generierten Token
     * @throws UnirestException
     */
    @Override
    public Auth login(User user) throws UnirestException {
        UserResponseDAO[] responseUser =Unirest.get(URL + "?q="+ URLEncoder.encode("{\"email\": \""+user.getEmail()+"\"}", StandardCharsets.UTF_8))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(UserResponseDAO[].class).getBody();
        System.out.println("-------Logs:------"+responseUser[0].getPassword() +" ist gleich "+ user.getPassword());
        System.out.println("-------Logs:------"+responseUser[0].get_id());
        System.out.println("-------Logs:------"+URL+"/"+responseUser[0].get_id());
        if (responseUser[0].getPassword().equals(user.getPassword())){
            TokenGenerator tokenGenerator = new TokenGenerator();
            String token = tokenGenerator.generateToken(responseUser[0].get_id());
            Unirest.put(URL+"/"+responseUser[0].get_id())
                    .header("content-type", "application/json")
                    .header("x-apikey", XAPIKEY)
                    .header("cache-control", "no-cache")
                    .body("{\"token\":\""+token+"\"}").asString();

            return new Auth(responseUser[0].get_id(), responseUser[0].getRole()[0].getIsAdmin(), token);
        }
        return null;
    }

    /**
     * Methode, die den User in der Datenbanktabelle abmeldet durch das Löschen des Tokens.
     *
     * @param auth wichtige User-Informationen zum Abmelden des Users (E-Mail und aktueller Token)
     * @see Auth
     * @return Boolean: Gibt zurück, ob das Logout funktioniert hat.
     * @throws UnirestException
     */
    @Override
    public Boolean logout(Auth auth) throws UnirestException {
        HttpResponse response= Unirest.put(URL+"/"+auth.getUserid())
                .header("content-type", "application/json")
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .body("{\"token\":\""+""+"\"}").asString();
        return response.getStatus() == 200;
    }

    /**
     * Methode, die überprüft, ob der User noch autorisiert ist.
     *
     * @param auth wichtige User-Informationen zur Überprüfung der Autorisierung.
     * @return Boolean: Gibt zurück, ob die Autorisierung funktioniert hat.
     * @throws UnirestException
     */
    @Override
    public Boolean isAuthorized(Auth auth) throws UnirestException {
        UserResponseDAO[] responseUser = Unirest.get(URL+"?q="+URLEncoder.encode("{\"_id\": \""+auth.getUserid()+"\"}", StandardCharsets.UTF_8))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(UserResponseDAO[].class).getBody();
        return responseUser[0].getToken().equals(auth.getToken());
    }
}
