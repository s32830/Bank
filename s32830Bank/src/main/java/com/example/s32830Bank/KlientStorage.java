package com.example.s32830Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KlientStorage {
    private List<Klient> KlientLista = new ArrayList<>();

    KlientStorage() {
        KlientLista.add(new Klient("Patryk", "Kwietniewski", "dsad@wp.pl",100.0, 1));
    }

    public boolean addKlient(String name, String surname, String email, double balance, int id) {
        KlientLista.add(new Klient(name, surname, email,balance, id));
        return true;
    }

    public Klient getKlientById(int clientId) {
        for (Klient klient : KlientLista) {
            if (klient.getId() == clientId) {
                return klient;
            }
        }
        return null;
    }

    public Klient getKlientByName(String name) {
        for (Klient klient : KlientLista) {
            if (klient.getName().equals(name)) {
                return klient;
            }
        }
        return null;
    }
}
