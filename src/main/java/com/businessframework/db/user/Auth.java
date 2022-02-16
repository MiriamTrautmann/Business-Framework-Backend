package com.businessframework.db.user;

/**
 * Java-Klasse, die die Informationsstruktur der Authentifizierung definiert.
 */
public class Auth {
    private String userid;
    private Boolean isAdmin;
    private String token;

    public Auth() {
    }

    public Auth(String userid, Boolean isAdmin, String token) {
        this.userid = userid;
        this.isAdmin = isAdmin;
        this.token = token;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
