package com.businessworkframe.db.tickets;

import com.businessworkframe.pages.dashboard.TicketDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

public interface TicketDb {
    TicketDisplay getAvgTickets () throws UnsupportedEncodingException, UnirestException;

}
