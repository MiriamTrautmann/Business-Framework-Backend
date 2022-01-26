package com.businessworkframe.db.tickets;

import com.businessworkframe.pages.dashboard.TicketDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;

/**
 * Java-Interface, welches die Methoden für den Datenaustausch mit der Ticket-Datenbanktabelle definiert.
 */
public interface TicketDb {
    TicketDisplay getAvgTickets () throws UnsupportedEncodingException, UnirestException;
    TicketDisplay getNewTickets() throws UnsupportedEncodingException, UnirestException;

}
