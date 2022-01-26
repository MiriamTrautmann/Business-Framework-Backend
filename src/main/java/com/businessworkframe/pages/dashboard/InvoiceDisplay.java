package com.businessworkframe.pages.dashboard;

import java.util.HashMap;

/**
 * Java-Klasse, die die Informationsstruktur für das Rechnungsdisplay definiert.
 */
public class InvoiceDisplay {

    private int invoiceNumber;
    private double targetAchievement;
    private HashMap invoiceCourse;

    public InvoiceDisplay() {
    }

    public InvoiceDisplay(int invoiceNumber, double targetAchievement, HashMap invoiceCourse) {
        this.invoiceNumber = invoiceNumber;
        this.targetAchievement = targetAchievement;
        this.invoiceCourse = invoiceCourse;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getTargetAchievement() {
        return targetAchievement;
    }

    public void setTargetAchievement(double targetAchievement) {
        this.targetAchievement = targetAchievement;
    }

    public HashMap getInvoiceCourse() {
        return invoiceCourse;
    }

    public void setInvoiceCourse(HashMap invoiceCourse) {
        this.invoiceCourse = invoiceCourse;
    }
}
