package com.example.s32830Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZlecenieStorage {
    private List<Zlecenie> ZlecenieLista = new ArrayList<>();

    ZlecenieStorage() {

    }

    public boolean addZlecenie(int id,double amount, int idTo, Klient klient, boolean status) {
        ZlecenieLista.add(new Zlecenie(id,amount, idTo, status, klient));
        return true;
    }

    public Zlecenie getZlecenieByIdTo(int idTo) {
        for (Zlecenie z : ZlecenieLista) {
            if (z.getIdTo() == idTo) {
                return z;
            }
        }
        return null;
    }
    public Zlecenie getZlecenieById(int id) {
        for (Zlecenie z : ZlecenieLista) {
            if (z.getId() == id) {
                return z;
            }
        }
        return null;
    }
}
