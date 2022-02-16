package com.businessframework.db.tickets;

import com.businessframework.pages.dashboard.TicketDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

/**
 * Java-Interface, das die Methoden für den Datenaustausch mit der Ticket-Datenbanktabelle definiert.
 */
public interface TicketDb {
    TicketDisplay getAvgTickets () throws UnsupportedEncodingException, UnirestException;
    TicketDisplay getNewTickets() throws UnsupportedEncodingException, UnirestException;

}
