package com.businessworkframe.pages.dashboard;

import java.util.HashMap;

public class NewCostumerDisplay {
    private int newCostumerNumber;
    private double targetAchievement;
    private HashMap customerIncrease;

    public NewCostumerDisplay() {
    }

    public NewCostumerDisplay(int newCostumerNumber, double targetAchievement, HashMap customerIncrease) {
        this.newCostumerNumber = newCostumerNumber;
        this.targetAchievement = targetAchievement;
        this.customerIncrease = customerIncrease;
    }

    public void setTargetAchievement(double targetAchievement) {
        this.targetAchievement = targetAchievement;
    }

    public double getTargetAchievement() {
        return targetAchievement;
    }

    public int getNewCostumerNumber() {
        return newCostumerNumber;
    }

    public void setNewCostumerNumber(int newCostumerNumber) {
        this.newCostumerNumber = newCostumerNumber;
    }

    public HashMap getCustomerIncrease() {
        return customerIncrease;
    }

    public void setCustomerIncrease(HashMap customerIncrease) {
        this.customerIncrease = customerIncrease;
    }
}
