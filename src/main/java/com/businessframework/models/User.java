package com.businessframework.models;

/**
 * Java-Klasse, die die Informationsstruktur eines Users definiert.
 */
public class User {
    private String firstName;
    private String name;
    private String department;
    private String office;
    private String location;
    private String email;
    private String password;
    private Role role;

    public User() {
    }

    public User(String firstName, String name, String department, String office, String location, String email, String password, Role role) {
        this.firstName = firstName;
        this.name = name;
        this.department = department;
        this.office = office;
        this.location = location;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

}
