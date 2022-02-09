package com.businessworkframe.db.dbDAOs;

import java.util.Date;

/**
 * Java-Klasse, die die Datenbank-Informationsstruktur einer Rechnung definiert.
 */
public class InvoiceDAO {
    private String _id;
    private int invoice_id;
    private int bp_id;
    private Date invoice_date;
    private long invoice_amount;
    private String currency_char;
    private long bp_order_id;
    private long position_id;

    public InvoiceDAO() {
    }

    public InvoiceDAO(String _id, int invoice_id, int bp_id, Date invoice_date, long invoice_amount, String currency_char, long bp_order_id, long position_id) {
        this._id = _id;
        this.invoice_id = invoice_id;
        this.bp_id = bp_id;
        this.invoice_date = invoice_date;
        this.invoice_amount = invoice_amount;
        this.currency_char = currency_char;
        this.bp_order_id = bp_order_id;
        this.position_id = position_id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getBp_id() {
        return bp_id;
    }

    public void setBp_id(int bp_id) {
        this.bp_id = bp_id;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }



    public String getCurrency_char() {
        return currency_char;
    }

    public void setCurrency_char(String currency_char) {
        this.currency_char = currency_char;
    }

    public long getInvoice_amount() {
        return invoice_amount;
    }

    public void setInvoice_amount(long invoice_amount) {
        this.invoice_amount = invoice_amount;
    }

    public long getBp_order_id() {
        return bp_order_id;
    }

    public void setBp_order_id(long bp_order_id) {
        this.bp_order_id = bp_order_id;
    }

    public long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(long position_id) {
        this.position_id = position_id;
    }
}
