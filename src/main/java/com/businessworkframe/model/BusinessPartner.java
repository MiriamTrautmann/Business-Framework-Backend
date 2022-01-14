package com.businessworkframe.model;

public class BusinessPartner {
    private String _id;
    private int bp_id;
    private String bp_name;
    private int bp_zip;
    private String bp_street;
    private int bp_housenumber;
    private String bp_contract_status;
    private String bp_role;
    private String bp_contact_person;
    private int bp_payment_term;
    private String bp_phonenumber;


    public BusinessPartner() {
    }

    public BusinessPartner(String _id, int bp_id, String bp_name, int bp_zip, String bp_street, int bp_housenumber, String bp_contract_status, String bp_role, String bp_contact_person, int bp_payment_term, String bp_phonenumber) {
        this._id = _id;
        this.bp_id = bp_id;
        this.bp_name = bp_name;
        this.bp_zip = bp_zip;
        this.bp_street = bp_street;
        this.bp_housenumber = bp_housenumber;
        this.bp_contract_status = bp_contract_status;
        this.bp_role = bp_role;
        this.bp_contact_person = bp_contact_person;
        this.bp_payment_term = bp_payment_term;
        this.bp_phonenumber = bp_phonenumber;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getBp_id() {
        return bp_id;
    }

    public void setBp_id(int bp_id) {
        this.bp_id = bp_id;
    }

    public String getBp_name() {
        return bp_name;
    }

    public void setBp_name(String bp_name) {
        this.bp_name = bp_name;
    }

    public String getBp_role() {
        return bp_role;
    }

    public void setBp_role(String bp_role) {
        this.bp_role = bp_role;
    }

    public String getBp_contact_person() {
        return bp_contact_person;
    }

    public void setBp_contact_person(String bp_contact_person) {
        this.bp_contact_person = bp_contact_person;
    }

    public int getBp_payment_term() {
        return bp_payment_term;
    }

    public void setBp_payment_term(int bp_payment_term) {
        this.bp_payment_term = bp_payment_term;
    }

    public int getBp_zip() {
        return bp_zip;
    }

    public void setBp_zip(int bp_zip) {
        this.bp_zip = bp_zip;
    }

    public String getBp_street() {
        return bp_street;
    }

    public void setBp_street(String bp_street) {
        this.bp_street = bp_street;
    }

    public int getBp_housenumber() {
        return bp_housenumber;
    }

    public void setBp_housenumber(int bp_housenumber) {
        this.bp_housenumber = bp_housenumber;
    }

    public String getBp_phonenumber() {
        return bp_phonenumber;
    }

    public void setBp_phonenumber(String bp_phonenumber) {
        this.bp_phonenumber = bp_phonenumber;
    }

    public String getBp_contract_status() {
        return bp_contract_status;
    }

    public void setBp_contract_status(String bp_contract_status) {
        this.bp_contract_status = bp_contract_status;
    }
}
