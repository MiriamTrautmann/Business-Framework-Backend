package com.businessworkframe.db.user;

public class Auth {
    private String benutzerid;
    private Boolean isAdmin;
    private String token;

    public Auth() {
    }

    public Auth(String benutzerid, Boolean isAdmin, String token) {
        this.benutzerid = benutzerid;
        this.isAdmin = isAdmin;
        this.token = token;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getBenutzerid() {
        return benutzerid;
    }

    public void setBenutzerid(String benutzerid) {
        this.benutzerid = benutzerid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
