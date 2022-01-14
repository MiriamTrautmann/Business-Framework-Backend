package com.businessworkframe.db.user;

import com.businessworkframe.db.dbDAOs.UserResponseDAO;
import com.businessworkframe.model.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LoginImpl implements  Login {

    private final String URL = "https://projektskizze-a175.restdb.io/rest/app-user";
    private final String XAPIKEY= "eaabcde666d8b00aa3ebf7e2c58aa29cfb44d" ;


    @Override
    public Auth login(User user) throws UnsupportedEncodingException, UnirestException {
        UserResponseDAO[] responseUser =Unirest.get(URL + "?q="+ URLEncoder.encode("{\"email\": \""+user.getEmail()+"\"}", "UTF-8"))
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

    @Override
    public Boolean logout(Auth auth) throws UnirestException {
        HttpResponse response= Unirest.put(URL+"/"+auth.getUserid())
                .header("content-type", "application/json")
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .body("{\"token\":\""+""+"\"}").asString();
        return response.getStatus() == 200;
    }

    @Override
    public Boolean isAuthorized(Auth auth) throws UnsupportedEncodingException, UnirestException {
        UserResponseDAO[] responseUser = Unirest.get(URL+"?q="+URLEncoder.encode("{\"_id\": \""+auth.getUserid()+"\"}", "UTF-8"))
                .header("x-apikey", XAPIKEY)
                .header("cache-control", "no-cache")
                .asObject(UserResponseDAO[].class).getBody();
        return responseUser[0].getToken().equals(auth.getToken());
    }
}
