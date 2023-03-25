package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Zaznam {
    public String jmeno;
    public String prijmeni;
    private final int vek;
    private final int telefonniCislo;

    public Zaznam(String jmeno, String prijmeni, int vek, int telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + ", " + vek + " let, tel.: " + telefonniCislo;
    }
}
