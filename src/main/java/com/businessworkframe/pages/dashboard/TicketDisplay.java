package com.businessworkframe.pages.dashboard;

import java.util.HashMap;

public class TicketDisplay {
    private int ticketTimeAvg;
    private double targetAchievement;
    private HashMap ticketCourse;

    public TicketDisplay() {
    }

    public TicketDisplay(int ticketTimeAvg, double targetAchievement, HashMap ticketCourse) {
        this.ticketTimeAvg = ticketTimeAvg;
        this.targetAchievement = targetAchievement;
        this.ticketCourse = ticketCourse;
    }

    public int getTicketTimeAvg() {
        return ticketTimeAvg;
    }

    public void setTicketTimeAvg(int ticketTimeAvg) {
        this.ticketTimeAvg = ticketTimeAvg;
    }

    public double getTargetAchievement() {
        return targetAchievement;
    }

    public void setTargetAchievement(double targetAchievement) {
        this.targetAchievement = targetAchievement;
    }

    public HashMap getTicketCourse() {
        return ticketCourse;
    }

    public void setTicketCourse(HashMap ticketCourse) {
        this.ticketCourse = ticketCourse;
    }
}
