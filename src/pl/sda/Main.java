package pl.sda;

import java.util.*;
import java.util.List;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //obiekty testowe
        Osoba osoba1 = new Osoba("Jan", "Kowalski", "966705422");
        Osoba osoba2 = new Osoba("Jan", "Nowak", "988705422");
        Paczkomat paczkomat1 = new Paczkomat("SCZ123", "h1c1", "Dworcowa, Warszawa, 02-786");
        Paczkomat paczkomat2 = new Paczkomat("WRO123", "h2c2", "Lipowa, Wrocław, 03-121");
        Paczka paczka1 = new Paczka("23", "g4h6", "21x43x3", 9, "nadawca", "odbiorca", "SCZ123", "WRO123", "nadana");
        Paczka paczka2 = new Paczka("56", "aaaaa", "21x43x3", 11, "nadawca", "odbiorca", "WRO123", "SCZ123", "w magazynie");
        for (Paczkomat paczkomat : Paczkomat.listaPaczkomat){
            System.out.println(paczkomat);
        }
        menu();

    }

    public static void menu(){
        System.out.println("Dostępne opcje:"
                + "\n1. Dodaj paczkomat"
                + "\n2. Usuń paczkomat"
                + "\n3. Wyświetl wszystkie paczkomaty"
                + "\n4. Wyswietl paczkomaty według miasta"
                + "\n5. Aktualizuj paczkomat"
                + "\n6. Dodaj paczke"
                + "\n7. Usuń paczkę"
                + "\n8. Wyświetl paczki w paczkomacie"
                + "\n9. Aktualizuj dane paczki"
                + "\n10. Exit"
                + "\nWpisz liczbę przypisaną do danej opcji: ");
        //Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(Objects.equals(input, "10"))
            System.exit(0);
        else if (input.equals("1")) {
            dodajPaczkomat();
        }else if (input.equals("2")) {
            usunPaczkomat();
        }else if (input.equals("3")) {
            wyswietlWszystkiePaczkomaty();
        }else if (input.equals("4")) {
            wyswietlPaczkomatyWedlugMiasta();
        }else if (input.equals("5")) {
            aktualizujPaczkomat();
        }else if (input.equals("6")) {
            dodajPaczke();
        }else if (input.equals("7")) {
            usunPaczke();
        }else if (input.equals("8")) {
            wyswietlPaczkiWPaczkomacie();
        }else if (input.equals("9")) {
            aktualizujPaczke();
        }else {
            System.out.println("nie poprawne polecenie");
            menu();
        }

    }

    private static void dodajPaczkomat(){
        System.out.println("Wpisz ID");
        String id = in.nextLine();
        System.out.println("Wpisz nazwę");
        String nazwa = in.nextLine();
        System.out.println("Wpisz adres");
        String adres = in.nextLine();
        Paczkomat paczkomat = new Paczkomat(id,nazwa,adres);
        System.out.println("Dodano paczkomat");
        menu();
    }

    private static void usunPaczkomat(){
        System.out.println("Wpisz ID paczkomatu do usunięcia");
        String id = in.nextLine();
        boolean found = false;
        for (int i = 0; i < Paczkomat.listaPaczkomat.size(); i++) {
            if (Paczkomat.listaPaczkomat.get(i).getId().contains(id)) {
                Paczkomat.listaPaczkomat.remove(i);
                found = true;
            }
        }
        if(found){
            System.out.println("Usunięto paczkomat o id: "+ id);
        }else {
            System.out.println("Nie znaleziono paczkomatu o id: "+ id);
        }
        menu();
    }

    private static void wyswietlWszystkiePaczkomaty(){
        for(Paczkomat paczkomat : Paczkomat.listaPaczkomat){
            System.out.println(paczkomat);
        }
        System.out.println();
        menu();
    }

    private static void wyswietlPaczkomatyWedlugMiasta(){
        System.out.println("Wpisz miasto");
        String miasto = in.nextLine();
        for(Paczkomat paczkomat : Paczkomat.listaPaczkomat){
            List<String> adresParts = Arrays.asList(paczkomat.getAdres().split("\\s*,\\s*"));
            if (miasto.equals(adresParts.get(1))){
                System.out.println(paczkomat);
            }
        }
        System.out.println("Nie znaleziono paczkomatów w mieście: "+ miasto);
        menu();
    }

    private static void aktualizujPaczkomat(){
        System.out.println("Wpisz ID paczkomatu do aktualizacji");
        String id = in.nextLine();
        for(Paczkomat paczkomat : Paczkomat.listaPaczkomat){
            if(Objects.equals(paczkomat.getId(), id)){
                System.out.println("Co zaktualizować? nazwa/adres");
                String elementDoZaktualizowania = in.nextLine();
                if(Objects.equals(elementDoZaktualizowania, "nazwa")){
                    System.out.println("Podaj nazwę");
                    paczkomat.setNazwa(in.nextLine());
                    System.out.println("Zmieniono nazwę" + paczkomat);
                    menu();
                } else if (Objects.equals(elementDoZaktualizowania, "adres")){
                    System.out.println("Podaj adres");
                    paczkomat.setAdres(in.nextLine());
                    System.out.println("Zmieniono adres" + paczkomat);
                    menu();
                }else {
                    System.out.println("Nie sprecyzowano nazwa czy adres");
                    menu();
                }
            }else {
                System.out.println("Nie znaleziono paczkomatu o id: "+ id);
            }
        }
        menu();
    }

    private static void dodajPaczke(){
        System.out.println("Podaj wymienione dane odzielone przecinkami"
                + "\nID, imie, rozmiar, waga, odbiorca, nadawca, ID paczkomatu odbiorcy, ID paczkomatu nadawcy, stan");
        String paczkaInfo = in.nextLine();
        List<String> paczkaParts = Arrays.asList(paczkaInfo.split("\\s*,\\s*"));
        Paczka paczka = new Paczka(paczkaParts.get(0), paczkaParts.get(1), paczkaParts.get(2), Double.parseDouble(paczkaParts.get(3)), paczkaParts.get(4), paczkaParts.get(5), paczkaParts.get(6), paczkaParts.get(7), paczkaParts.get(8));
        System.out.println("Utworzono paczkę: \n" + paczka);
        menu();
    }

    private static void usunPaczke(){
        System.out.println("Wpisz ID paczki do usunięcia");
        String id = in.nextLine();
        boolean found = false;
        for (int i = 0; i < Paczka.listaPaczka.size(); i++) {
            if (Paczka.listaPaczka.get(i).getId().contains(id)) {
                Paczka.listaPaczka.remove(i);
                found = true;
            }
        }
        if(found){
            System.out.println("Usunięto paczki o id: "+ id);
        }else {
            System.out.println("Nie znaleziono paczki o id: "+ id);
        }
        menu();
    }

    private static void wyswietlPaczkiWPaczkomacie(){
        System.out.println("Wpisz ID paczkomatu");
        String id = in.nextLine();
        boolean found = false;
        for (Paczkomat paczkomat : Paczkomat.listaPaczkomat) {
            if (paczkomat.getId().contains(id)) {
                found = true;
                List<Paczka> paczki = new ArrayList<>();
                for(Paczka paczka : Paczka.listaPaczka){
                    if(paczka.getPaczkomatNadawcy().equals(paczkomat)){
                        System.out.println("Paczka w paczkomacie nadawcy: \n"+ paczka);
                        System.out.println();
                    } else if (paczka.getPaczkomatOdbiorcy().equals(paczkomat)) {
                        System.out.println("Paczka w paczkomacie odbiorcy: \n"+ paczka);
                        System.out.println();
                    }
                }

            }
        }
        if(found){
            menu();
        }else {
            System.out.println("Nie znaleziono paczkomatu o id: "+ id);
        }
    }

    private static void aktualizujPaczke(){
        System.out.println("Wpisz ID paczki do aktualizacji");
        String id = in.nextLine();
        for(Paczka paczka : Paczka.listaPaczka){
            if(Objects.equals(paczka.getId(), id)){
                System.out.println("Co zaktualizować? imie/rozmiar/waga/odbiorca/nadawca/paczkomat nadawcy/paczkomat odbiorcy/stan");
                String elementDoZaktualizowania = in.nextLine();
                if(Objects.equals(elementDoZaktualizowania, "imie")){
                    System.out.println("Podaj nazwę");
                    paczka.setImie(in.nextLine());
                    System.out.println("Zmieniono imie");
                    menu();
                } else if (Objects.equals(elementDoZaktualizowania, "rozmiar")){
                    System.out.println("Podaj rozmiar");
                    paczka.setRozmiar(in.nextLine());
                    System.out.println("Zmieniono rozmiar");
                    menu();
                } else if (Objects.equals(elementDoZaktualizowania, "waga")){
                    System.out.println("Podaj wage");
                    paczka.setWaga(Double.parseDouble(in.nextLine()));
                    System.out.println("Zmieniono wage");
                    menu();
                } else if (Objects.equals(elementDoZaktualizowania, "odbiorca")){
                    System.out.println("Podaj PESEL odbiorcy");
                    paczka.setOdbiorca(in.nextLine());
                    System.out.println("Zmieniono odbiorce");
                    menu();
                } else if (Objects.equals(elementDoZaktualizowania, "nadawca")){
                    System.out.println("Podaj PESEL nadawcy");
                    paczka.setOdbiorca(in.nextLine());
                    System.out.println("Zmieniono nadawcy");
                    menu();
                }else {
                    System.out.println("Nie sprecyzowano elementu do aktualizacji");
                    menu();
                }
            }else {
                System.out.println("Nie znaleziono paczkomatu o id: "+ id);
            }
        }
        menu();
    }
}
