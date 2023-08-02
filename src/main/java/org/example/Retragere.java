package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Retragere {
    public Birou<Angajat> cerereAngajat (Birou<Angajat> cereriAngajati, String[] data, SimpleDateFormat formatter)
            throws ParseException {
        for (Cerere c : cereriAngajati.getCereri()) {
            if (c.getUtilizator().getNume().equals(data[1]) &&
                    c.getData().equals(formatter.parse(data[2]))) {
                cereriAngajati.getCereri().remove(c);
                break;
            }
        }
        return cereriAngajati;
    }

    public Birou<Elev> cerereElev (Birou<Elev> cereriElevi, String[] data, SimpleDateFormat formatter)
            throws ParseException {
        for (Cerere c : cereriElevi.getCereri()) {
            if (c.getUtilizator().getNume().equals(data[1]) &&
                    c.getData().equals(formatter.parse(data[2]))) {
                cereriElevi.getCereri().remove(c);
                break;
            }
        }
        return cereriElevi;
    }

    public Birou<EntitateJuridica> cerereEntitateJuridica (Birou<EntitateJuridica> cereriEntitatiJuridice,
                                                           String[] data, SimpleDateFormat formatter)
            throws ParseException {
        for (Cerere c : cereriEntitatiJuridice.getCereri()) {
            if (c.getUtilizator().getNume().equals(data[1]) &&
                    c.getData().equals(formatter.parse(data[2]))) {
                cereriEntitatiJuridice.getCereri().remove(c);
                break;
            }
        }
        return cereriEntitatiJuridice;
    }

    public Birou<Pensionar> cererePensionar (Birou<Pensionar> cereriPensionari, String[] data,
                                             SimpleDateFormat formatter) throws ParseException {
        for (Cerere c : cereriPensionari.getCereri()) {
            if (c.getUtilizator().getNume().equals(data[1]) &&
                    c.getData().equals(formatter.parse(data[2]))) {
                cereriPensionari.getCereri().remove(c);
                break;
            }
        }
        return cereriPensionari;
    }

    public Birou<Persoana> cererePersoana (Birou<Persoana> cereriPersoane, String[] data, SimpleDateFormat formatter)
            throws ParseException {
        for (Cerere c : cereriPersoane.getCereri()) {
            if (c.getUtilizator().getNume().equals(data[1]) &&
                    c.getData().equals(formatter.parse(data[2]))) {
                cereriPersoane.getCereri().remove(c);
                break;
            }
        }
        return cereriPersoane;
    }
}
