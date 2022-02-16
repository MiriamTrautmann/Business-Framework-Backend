package com.businessframework.models;

/**
 * Java-Klasse, die die Informationsstruktur einer Rolle im System definiert.
 */
public class Role {
    private String roleName;
    private Boolean isAdmin;

    public Role() {
    }

    public Role(String roleName, Boolean isAdmin) {
        this.roleName = roleName;
        this.isAdmin = isAdmin;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
