package org.example;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cerere implements Comparable<Object>{
    private final String text;
    private final Date data;
    byte prioritate;

    Utilizator utilizator;

    public Cerere(String text, Date data, byte prioritate, Utilizator utilizator) {
        this.text = text;
        this.data = data;
        this.prioritate = prioritate;
        this.utilizator = utilizator;
    }


    enum CereriPosibile {
        INLOCUIRE_BULETIN,
        INREGISTRARE_VENIT_SALARIAL,
        INLOCUIRE_CARNET_DE_SOFER,
        INLOCUIRE_CARNET_DE_ELEV,
        CREARE_ACT_CONSTITUTIV,
        REINNOIRE_AUTORIZATIE,
        INREGISTRARE_CUPOANE_DE_PENSIE
    }

    public String getText() {
        return text;
    }

    public Date getData() {
        return data;
    }

    public byte getPrioritate() {
        return prioritate;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    @Override
    public int compareTo(Object o) {
        if (this.data.before(((Cerere)o).getData())) {
            return -1;
        }
        else if (this.data.equals(((Cerere)o).getData())) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        return formatter.format(this.data).replace("Sept", "Sep") + " - " + this.text;
    }
}

class ExceptieCerere extends Exception {
    final String eroare;
    public ExceptieCerere(String s) {
        this.eroare = s;
    }
}