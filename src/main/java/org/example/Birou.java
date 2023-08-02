package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Birou<E extends Utilizator> {

    private final ArrayList<Cerere> cereri = new ArrayList<>();

    E verifica;

    public List<Cerere> getCereri() {
        return cereri;
    }

    public Birou(E verifica){
        this.verifica = verifica;
    }
    public void adaugaCerere(Cerere c) {
        if (c.getUtilizator().getClass().equals(verifica.getClass())) {
            this.cereri.add(c);
        }
    }
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
        StringBuilder afisare = new StringBuilder();
        for (Cerere c : this.cereri) {
            afisare.append(c.getPrioritate()).append(" - ").append(formatter.format(c.getData())).
                    append(" - ").append(c.getText());
        }
        return afisare.toString();
    }
}

class ComparatorCereri implements Comparator<Cerere> {

    @Override
    public int compare(Cerere o1, Cerere o2) {
        if (o1.getPrioritate() < o2.getPrioritate())
            return 1;
        else if (o1.getPrioritate() > o2.getPrioritate())
            return -1;
        else {
            if (o1.getData().before(o2.getData()))
                return -1;
            else if (o1.getData().after(o2.getData()))
                return 1;
            else return 0;
        }
    }
}
