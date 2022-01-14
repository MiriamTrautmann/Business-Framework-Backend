package com.businessworkframe.db.dbDAOs;

import java.util.Date;

public class TicketDAO {

    private String _id;
    private int ticket_ID;
    private Date creation_date;
    private Date close_date;
    private String customer;

    public TicketDAO() {
    }

    public TicketDAO(String _id, int ticket_ID, Date creation_date, Date close_date, String customer) {
        this._id = _id;
        this.ticket_ID = ticket_ID;
        this.creation_date = creation_date;
        this.close_date = close_date;
        this.customer = customer;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getTicket_ID() {
        return ticket_ID;
    }

    public void setTicket_ID(int ticket_ID) {
        this.ticket_ID = ticket_ID;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getClose_date() {
        return close_date;
    }

    public void setClose_date(Date close_date) {
        this.close_date = close_date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
