package com.businessframework.models;

import java.util.Date;

/**
 * Java-Klasse, die die Informationsstruktur der CRM-Daten definiert.
 */
public class Crm {
    int nr;
    String name;
    int zip;
    String city;
    String street;
    int housenumber;
    String country;
    String status;
    String contract_person_inter;
    String contract_person_external;
    int active_pipeline;
    String website;
    String timezone;
    String industry;
    String tax_id;
    String notes;
    String role;
    String contract_status;
    String phone_contract;
    Date creation_date;

    public Crm(int nr) {
        this.nr = nr;
    }

    public Crm(int nr, String name, int zip, String city, String street, int housenumber, String country, String status, String contract_person_inter, String contract_person_external, int active_pipeline, String website, String timezone, String industry, String tax_id, String notes, String role, String contract_status, String phone_contract, Date creation_date) {
        this.nr = nr;
        this.name = name;
        this.zip = zip;
        this.city = city;
        this.street = street;
        this.housenumber = housenumber;
        this.country = country;
        this.status = status;
        this.contract_person_inter = contract_person_inter;
        this.contract_person_external = contract_person_external;
        this.active_pipeline = active_pipeline;
        this.website = website;
        this.timezone = timezone;
        this.industry = industry;
        this.tax_id = tax_id;
        this.notes = notes;
        this.role = role;
        this.contract_status = contract_status;
        this.phone_contract = phone_contract;
        this.creation_date = creation_date;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContract_person_inter() {
        return contract_person_inter;
    }

    public void setContract_person_inter(String contract_person_inter) {
        this.contract_person_inter = contract_person_inter;
    }

    public String getContract_person_external() {
        return contract_person_external;
    }

    public void setContract_person_external(String contract_person_external) {
        this.contract_person_external = contract_person_external;
    }

    public int getActive_pipeline() {
        return active_pipeline;
    }

    public void setActive_pipeline(int active_pipeline) {
        this.active_pipeline = active_pipeline;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContract_status() {
        return contract_status;
    }

    public void setContract_status(String contract_status) {
        this.contract_status = contract_status;
    }

    public String getPhone_contract() {
        return phone_contract;
    }

    public void setPhone_contract(String phone_contract) {
        this.phone_contract = phone_contract;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
