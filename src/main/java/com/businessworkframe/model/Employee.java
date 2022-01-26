package com.businessworkframe.model;

import java.util.Date;

/**
 * Java-Klasse, die die Informationsstruktur eines Mitarbeiters definiert.
 */
public class Employee {
    private String _id;
    private String titel;
    private String first_name;
    private String second_name;
    private Date birthday;
    private String street;
    private int housenumber;
    private int zip;
    private String city;
    private String phonenumber;
    private String mail_adress;
    private Date entry_date;
    private String department;

    public Employee() {
    }

    public Employee(String _id, String titel, String first_name, String second_name, Date birthday, String street, int housenumber, int zip, String city, String phonenumber, String mail_adress, Date entry_date, String department) {
        this._id = _id;
        this.titel = titel;
        this.first_name = first_name;
        this.second_name = second_name;
        this.birthday = birthday;
        this.street = street;
        this.housenumber = housenumber;
        this.zip = zip;
        this.city = city;
        this.phonenumber = phonenumber;
        this.mail_adress = mail_adress;
        this.entry_date = entry_date;
        this.department = department;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMail_adress() {
        return mail_adress;
    }

    public void setMail_adress(String mail_adress) {
        this.mail_adress = mail_adress;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
