package com.example.s32830Bank;

import org.springframework.stereotype.Component;

@Component
public class Bank {
    private final KlientStorage klientStorage;
    private final ZlecenieStorage zlecenieStorage;

    public Bank(KlientStorage klientStorage, ZlecenieStorage zlecenieStorage) {
        this.klientStorage = klientStorage;
        this.zlecenieStorage = zlecenieStorage;
    }

    public boolean Saveklient(int id, String name, String Surname, String email, Double balance) {
        if (klientStorage.getKlientById(id) == null) {
            if (balance > 0) {
                klientStorage.addKlient(name, Surname, email, balance, id);
                System.out.println("Pomyślnie dodano klienta");
                return true;
            }
        } else {
            System.out.println("Taki klient juz istnieje");
            return false;
        }
        return false;
    }

    public Zlecenie zlecenie(int id, double amount, int idTo,  boolean status) {
        Klient klient = klientStorage.getKlientById(idTo);
        if(klient != null) {
            zlecenieStorage.addZlecenie(id ,amount, idTo, klient, status);
            klient.addBalance(amount);
            Zlecenie z = zlecenieStorage.getZlecenieById(id);
            return z;
        }
        return null;
    }


    public Zlecenie deposit(int id,double amount, int idTo,  boolean status) {
        Klient klient = klientStorage.getKlientById(idTo);
        if(klient != null) {
            if(amount > 0) {
                zlecenieStorage.addZlecenie(id,amount,idTo,klient,status);
                klient.addBalance(amount);
                Zlecenie z = zlecenieStorage.getZlecenieById(id);
                return z;
            }
        }
        return null;
    }

    public Klient readKlient(int id){
        Klient klient = klientStorage.getKlientById(id);
            return klient;
    }

}
