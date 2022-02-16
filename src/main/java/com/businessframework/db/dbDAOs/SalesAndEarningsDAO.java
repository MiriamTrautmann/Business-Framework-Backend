package com.businessframework.db.dbDAOs;

import java.util.Date;

/**
 * Java-Klasse, die die Datenbank-Informationsstruktur eines SalesAndEarning-Datenbankobjekts definiert.
 */
public class SalesAndEarningsDAO {
    private String _id;
    private int year;
    private int month;
    private int cost;
    private int equity_capital;
    private int borrowed_capital;
    private int total_capital;
    private Date date;
    private int sales_volume;
    private int earnings;

    public SalesAndEarningsDAO() {
    }

    public SalesAndEarningsDAO(String _id, int year, int month, int cost, int equity_capital, int borrowed_capital, int total_capital, Date date, int sales_volume, int earnings) {
        this._id = _id;
        this.year = year;
        this.month = month;
        this.cost = cost;
        this.equity_capital = equity_capital;
        this.borrowed_capital = borrowed_capital;
        this.total_capital = total_capital;
        this.date = date;
        this.sales_volume = sales_volume;
        this.earnings = earnings;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getEquity_capital() {
        return equity_capital;
    }

    public void setEquity_capital(int equity_capital) {
        this.equity_capital = equity_capital;
    }

    public int getBorrowed_capital() {
        return borrowed_capital;
    }

    public void setBorrowed_capital(int borrowed_capital) {
        this.borrowed_capital = borrowed_capital;
    }

    public int getTotal_capital() {
        return total_capital;
    }

    public void setTotal_capital(int total_capital) {
        this.total_capital = total_capital;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(int sales_volume) {
        this.sales_volume = sales_volume;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
}
