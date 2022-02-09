package com.businessworkframe.pages.dashboard;

import java.util.TreeMap;


/**
 * Java-Klasse, die die Informationsstruktur für die Ticket-Anzeigen definiert.
 */
public class TicketDisplay {
    private int ticketTime;
    private double targetAchievement;
    private TreeMap ticketCourse;

    public TicketDisplay() {
    }

    public TicketDisplay(int ticketTime, double targetAchievement, TreeMap ticketCourse) {
        this.ticketTime = ticketTime;
        this.targetAchievement = targetAchievement;
        this.ticketCourse = ticketCourse;
    }

    public int getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(int ticketTime) {
        this.ticketTime = ticketTime;
    }

    public double getTargetAchievement() {
        return targetAchievement;
    }

    public void setTargetAchievement(double targetAchievement) {
        this.targetAchievement = targetAchievement;
    }

    public TreeMap getTicketCourse() {
        return ticketCourse;
    }

    public void setTicketCourse(TreeMap ticketCourse) {
        this.ticketCourse = ticketCourse;
    }
}
