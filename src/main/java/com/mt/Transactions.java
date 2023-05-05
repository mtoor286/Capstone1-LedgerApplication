package com.mt;

public class Transactions {
/////////////////////////////////////////////  Properties
    private String Date;
    private String Time;
    private String Description;
    private String Vendor;
    private static double Amount;
//////////////////////////////////////////////  Constructor
    public Transactions(String date, String time, String description, String vendor, double amount) {
        Date = date;
        Time = time;
        Description = description;
        Vendor = vendor;
        Amount = amount;
    }
//////////////////////////////////////////////  Getters
    public String getDate() {
        return Date;
    }
    public String getTime() {
        return Time;
    }
    public String getDescription() {
        return Description;
    }
    public String getVendor() {
        return Vendor;
    }
    public static double getAmount() {
        return Amount;
    }
//////////////////////////////////////////////  Setters
    public void setDate(String date) {
        Date = date;
    }
    public void setTime(String time) {
        Time = time;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public void setVendor(String vendor) {
        Vendor = vendor;
    }
    public void setAmount(double amount) {
        Amount = amount;
    }
}
