package com.example.s32830Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class BankTest {

    @Autowired
    private Bank bank;

    @MockitoBean
    private KlientStorage klientStorage;

    @MockitoBean
    private ZlecenieStorage zlecenieStorage;

    @Test
    void saveKlient() {
        when(klientStorage.getKlientById(1)).thenReturn(null);
        boolean result = bank.Saveklient(1, "Patryk", "Kwietniewski", "dsad@wp.pl", 100.0);
        assertThat(result).isTrue();
    }

    @Test
    void NotsaveKlient() {
        Klient klient = new Klient("Patryk", "Kwietniewski", "dsad@wp.pl", 100, 1);
        when(klientStorage.getKlientById(1)).thenReturn(klient);
        boolean result = bank.Saveklient(1, "Patryk", "Kwietniewski", "dsad@wp.pl", 100.0);
        assertThat(result).isFalse();
    }

    @Test
    void zlecenie() {
        Klient klient = new Klient("Jan", "Nowak", "jan@wp.pl", 100, 1);
        when(klientStorage.getKlientById(1)).thenReturn(klient);
        Zlecenie result = bank.zlecenie(1, 50, 1, true);
        //assertThat(result).isNotNull();
        assertThat(klient.getBalance()).isEqualTo(150);
    }

    @Test
    void AmountNegtivedeposit() {
        Klient klient = new Klient("Jan", "Nowak", "jan@wp.pl", 100, 1);
        when(klientStorage.getKlientById(1)).thenReturn(klient);
        Zlecenie result = bank.deposit(1, -50, 1, true);
        assertThat(result).isNull();
    }

    @Test
    void readKlient() {
        Klient klient = new Klient("Jan", "Nowak", "jan@wp.pl", 100, 1);
        when(klientStorage.getKlientById(1)).thenReturn(klient);
        Klient result = bank.readKlient(1);
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Jan");
    }
}
