package pl.sda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paczkomat {
    public static List<Paczkomat> listaPaczkomat = new ArrayList<>();

    private String id;
    private String nazwa;
    private String adres;

    public Paczkomat(String id, String nazwa, String adres) {
        if(!id.matches("^[A-Z0-9]+$")){
            System.out.println("zle id: "+ id);
            Main.menu();
        }else {
            this.id = id;
        }

        setNazwa(nazwa);
        setAdres(adres);
        listaPaczkomat.add(this);
    }

    private boolean validateAdres(String adres){
        List<String> adresParts = Arrays.asList(adres.split("\\s*,\\s*"));
        if (adresParts.size() == 3 /*&& adresParts.get(2).matches("\\d-\\d")*/){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Paczkomat{" +
                "id='" + id + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }

    public String getAdres() {
        return adres;
    }

    public String getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        if(nazwa == null){
            System.out.println("zla nazwa: "+ nazwa);
            Main.menu();
        }else {
            this.nazwa = nazwa;
        }
    }

    public void setAdres(String adres) {
        if(!validateAdres(adres)){
            System.out.println("zly adres:"+ adres);
            Main.menu();
        }else {
            this.adres = adres;
        }
    }
}
