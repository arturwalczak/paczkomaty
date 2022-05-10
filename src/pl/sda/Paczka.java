package pl.sda;

import java.util.ArrayList;
import java.util.List;

public class Paczka {

    public static List<Paczka> listaPaczka = new ArrayList<>();
    private String id;
    private String imie;
    private String rozmiar;
    private double waga;
    private Osoba odbiorca;
    private Osoba nadawca;
    private Paczkomat paczkomatNadawcy;
    private Paczkomat paczkomatOdbiorcy;
    private String stan;

    public Paczka(String id, String imie, String rozmiar, double waga, String odbiorca, String nadawca, String idPaczkomatNadawcy, String idPaczkomatOdbiorcy, String stan) {
        if(id.isEmpty()){
            System.out.println("brak id");
            Main.menu();
        }else {
            this.id = id;
        }
        setImie(imie);
        setOdbiorca(odbiorca);
        setNadawca(nadawca);
        setPaczkomatNadawcy(idPaczkomatNadawcy);
        setPaczkomatOdbiorcy(idPaczkomatOdbiorcy);
        this.rozmiar = rozmiar;
        this.waga = waga;
        this.stan = stan;
        listaPaczka.add(this);
    }

    private Paczkomat findPaczkomat(String id){
        Paczkomat paczkomat = null;
        for (int i = 0; i < Paczkomat.listaPaczkomat.size(); i++) {
            if (Paczkomat.listaPaczkomat.get(i).getId().contains(id)) {
                paczkomat = Paczkomat.listaPaczkomat.get(i);
            }
        }
        return paczkomat;
    }

    private Osoba findOsoba(String id){
        Osoba osoba = null;
        for (int i = 0; i < Osoba.listOsoba.size(); i++) {
            if (Osoba.listOsoba.get(i).getPESEL().contains(id)) {
                osoba = Osoba.listOsoba.get(i);
            }
        }
        return osoba;
    }

    public String getId() {
        return id;
    }

    public void setImie(String imie) {
        if(imie == null){
            System.out.println("brak imie");
            Main.menu();
        }else {
            this.imie = imie;
        }
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public void setOdbiorca(String odbiorca) {
        if(odbiorca.isEmpty()){
            System.out.println("brak odbiorcy");
            Main.menu();
        }else {
            this.odbiorca = findOsoba(odbiorca);
        }
    }

    public void setNadawca(String nadawca) {
        if(nadawca.isEmpty()){
            System.out.println("brak nadawcy");
            Main.menu();
        }else {
            this.nadawca = findOsoba(nadawca);
        }
    }



    public void setPaczkomatNadawcy(String idPaczkomatNadawcy) {
        if(findPaczkomat(idPaczkomatNadawcy) == null){
            System.out.println("brak paczkomatu nadawcy o id: "+ id);
            Main.menu();
        }else {
            this.paczkomatNadawcy = findPaczkomat(idPaczkomatNadawcy);
        }
    }

    public void setPaczkomatOdbiorcy(String idPaczkomatOdbiorcy) {
        if(findPaczkomat(idPaczkomatOdbiorcy) == null){
            System.out.println("brak paczkomatu odbiorcy o id: "+ id);
            Main.menu();
        }else {
            this.paczkomatOdbiorcy = findPaczkomat(idPaczkomatOdbiorcy);
        }
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public Paczkomat getPaczkomatNadawcy() {
        return paczkomatNadawcy;
    }

    public Paczkomat getPaczkomatOdbiorcy() {
        return paczkomatOdbiorcy;
    }

    @Override
    public String toString() {
        return "Paczka{" +
                "id='" + id + '\'' +
                ", imie='" + imie + '\'' +
                ", rozmiar='" + rozmiar + '\'' +
                ", waga=" + waga +
                ", odbiorca='" + odbiorca + '\'' +
                ", nadawca='" + nadawca + '\'' +
                ", paczkomatNadawcy=" + paczkomatNadawcy +
                ", paczkomatOdbiorcy=" + paczkomatOdbiorcy +
                ", stan='" + stan + '\'' +
                '}';
    }
}
