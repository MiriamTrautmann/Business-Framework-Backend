package com.businessworkframe.db.dbDAOs;

public class UserResponseDAO {
    private String _id;
    private String email;
    private String password;
    private String token;
    private RoleDAO[] role;

    public UserResponseDAO() {
    }

    public UserResponseDAO(String _id, String email, String password, String token, RoleDAO[] role) {
        this._id = _id;
        this.email = email;
        this.password = password;
        this.token = token;
        this.role = role;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RoleDAO[] getRole() {
        return role;
    }

    public void setRole(RoleDAO[] role) {
        this.role = role;
    }
}
