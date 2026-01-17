package com.example.s32830Bank;

public class Klient {
    private int id;
    private String name;
    private String Surname;
    private String Email;
    private double balance;

    public Klient(String name, String Surname, String Email, double balance, int id) {
        this.name = name;
        this.Surname = Surname;
        this.Email = Email;
        this.balance = balance;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void removeBalance(double amount) {
        this.balance -= amount;
    }
    public void addBalance(double amount) {
        this.balance += amount;
    }
}
