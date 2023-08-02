package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Afisari {

    public void cereriAsteptare(List<Utilizator> utilizatori, String[] data, FileWriter fw) throws IOException {
        for (Utilizator u : utilizatori) {
            if (u.getNume().equals(data[1])) {
                fw.write(data[1] + " - cereri in asteptare:\n");
                for (Cerere c : u.getCereriAsteptare()) {
                    fw.write(c.toString());
                }
            }
        }
    }

    public void cereri(Birou<Angajat> cereriAngajati, Birou<Elev> cereriElevi,
                       Birou<EntitateJuridica> cereriEntitatiJuridice, Birou<Pensionar> cereriPensionari,
                       Birou<Persoana> cereriPersoane, String[] data, FileWriter fw) throws IOException {
        fw.write(data[1] + " - cereri in birou:\n");
        switch (data[1]) {
            case "angajat":
                cereriAngajati.getCereri().sort(new ComparatorCereri());
                fw.write(cereriAngajati.toString());
                break;
            case "elev":
                cereriElevi.getCereri().sort(new ComparatorCereri());
                fw.write(cereriElevi.toString());
                break;
            case "entitate juridica":
                cereriEntitatiJuridice.getCereri().sort(new ComparatorCereri());
                fw.write(cereriEntitatiJuridice.toString());
                break;
            case "pensionar":
                cereriPensionari.getCereri().sort(new ComparatorCereri());
                fw.write(cereriPensionari.toString());
                break;
            case "persoana":
                cereriPersoane.getCereri().sort(new ComparatorCereri());
                fw.write(cereriPersoane.toString());
                break;
            default:
                break;
        }
    }

    public void cereriFinalizate(List<Utilizator> utilizatori, String[] data, FileWriter fw) throws IOException {
        for (Utilizator u : utilizatori) {
            if (u.getNume().equals(data[1])) {
                fw.write(data[1] + " - cereri in finalizate:\n");
                for (Cerere c : u.getCereriSolutionate()) {
                    fw.write(c.toString());
                }
            }
        }
    }
}
