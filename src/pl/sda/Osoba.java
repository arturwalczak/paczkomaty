package pl.sda;

import java.util.ArrayList;
import java.util.List;

public class Osoba {

    public static List <Osoba> listOsoba = new ArrayList<>();

    private String imie;
    private String nazwisko;
    private String PESEL;

    public Osoba(String imie, String nazwisko, String PESEL) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        listOsoba.add(this);
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                '}';
    }

    public String getPESEL() {
        return PESEL;
    }
}
