package com.example.s32830Bank;

public class Zlecenie {
    private int id;
    private double amount;
    private int idTo;
    private boolean status;
    private double newbalance;

    public Zlecenie(int id,double amount, int idTo, boolean status, Klient klient) {
        double balance = klient.getBalance();
        this.idTo = id;
        this.amount = amount;
        this.idTo = idTo;
        this.status = status;
        this.newbalance = amount + balance;
    }
    public double getamount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public int getIdTo() {
        return idTo;
    }
    public void setIdTo(int idTo) {
        this.idTo = idTo;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public double getnewbalance() {
        return newbalance;
    }
    public void setnewbalance(double newbalance) {
        this.newbalance = newbalance;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {}


}
