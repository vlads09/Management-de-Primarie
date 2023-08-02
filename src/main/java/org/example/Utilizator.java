package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public abstract class Utilizator {

    private String nume;

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    private final Set<Cerere> cereriSolutionate = new TreeSet<>(Cerere::compareTo);
    private final Set<Cerere> cereriAsteptare = new TreeSet<>(Cerere::compareTo);

    public Set<Cerere> getCereriSolutionate() {
        return cereriSolutionate;
    }

    public Set<Cerere> getCereriAsteptare() {
        return cereriAsteptare;
    }

    abstract String scriereCerere(Cerere.CereriPosibile tip);

    public Cerere creareaUneiCereri(Cerere.CereriPosibile tip, byte prioritate, Date data) {
        Cerere c = new Cerere(scriereCerere(tip), data, prioritate, this);
        cereriAsteptare.add(c);
        return c;
    }

    public int retragereaUneiCereri(String data) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        for (Cerere aux : cereriAsteptare) {
            Date d = formatter.parse(data);
            if (d.equals(aux.getData())) {
                cereriAsteptare.remove(aux);
                return 1;
            }
        }
        return 0;
    }
}
