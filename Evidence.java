package org.example;

import java.util.LinkedList;
import java.util.Scanner;

public class Evidence {

    private LinkedList<Zaznam> zaznamy = new LinkedList<>();
    private Zaznam aktualniZaznam;
    private Scanner sc = new Scanner(System.in);

    public void Program() {

        String volba = "";

        while (!volba.equals("4")) {
            VypisMenu();

            if (aktualniZaznam != null) {
                try {
                    aktualniZaznam = zaznamy.getLast();
                } catch (Exception e) {
                    // System.out.println("Nejsou zde žádné záznamy.");
                }
            }

            System.out.print("Zadejte vaši volbu: ");
            volba = sc.nextLine();

            switch (volba) {
                case "1":
                    VytvorNovyZaznam();
                    break;

                case "2":
                    UkazVsechnyPojistene();
                    break;

                case "3":
                    if (zaznamy.size() != 0) {
                        VyhledejPojisteneho();
                    } else {
                        System.out.println("\n Evidence je prázdná \n");
                    }
                    break;

                case "4":
                    System.out.println(" Konec ");
                    break;
            }
        }

    }

    void VypisPocetZaznamu() {
        System.out.println("------------------------------------------");
        System.out.println("Počet pojištěných: " + zaznamy.size());
        System.out.println("------------------------------------------");
    }

    void VypisMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("------------------------------------------------");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");
        VypisPocetZaznamu();
    }

    void VytvorNovyZaznam() {
        System.out.println("------------------------------------------------");
        System.out.println("Zadejte jméno pojištěného: ");
        String jmeno = sc.nextLine();

        System.out.println("Zadejte příjmení pojištěného: ");
        String prijmeni = sc.nextLine();

        System.out.println("Zadejte telefonní číslo: ");
        int telefonniCislo = Integer.parseInt(sc.nextLine());

        System.out.println("Zadejte věk: ");
        int vek = Integer.parseInt(sc.nextLine());

        Zaznam zaznam = new Zaznam(jmeno, prijmeni, vek, telefonniCislo);
        zaznamy.add(zaznam);

        aktualniZaznam = zaznam;

        System.out.println("Záznam byl vytvořen");
        System.out.println("------------------------------------------------");
    }

    void UkazVsechnyPojistene() {
        VypisPocetZaznamu();

        System.out.println("------------------------------------------------");
        System.out.println("V evidenci pojištěných máme:");
        for (int i = 0; i < zaznamy.size(); i++) {
            System.out.println(zaznamy.get(i).toString() + "\n");

        }
        System.out.println("********************************************");
    }

    void VyhledejPojisteneho() {
        System.out.println("------------------------------------------------");
        System.out.println("Zadejte jméno nebo příjmení pojištěného:");
        String hledany = sc.nextLine();

        boolean nalezeno = false;
        for (Zaznam zaznam : zaznamy) {
            if (zaznam.jmeno.equalsIgnoreCase(hledany) || zaznam.prijmeni.equalsIgnoreCase(hledany)) {
                System.out.println("Nalezen pojištěný: " + zaznam.toString());
                nalezeno = true;
            }
        }

        if (!nalezeno) {
            System.out.println("Pojištěný s tímto jménem nebo příjmením nebyl nalezen.");
        }

        System.out.println("------------------------------------------------");
    }
}

