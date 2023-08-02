package org.example;

import java.util.List;

public class Rezolva {
    public Birou<Angajat> cerereAngajat(Birou<Angajat> cereriAngajati, List<Utilizator> utilizatori,
                                        FunctionarPublic fp) {
        Cerere c = cereriAngajati.getCereri().get(0);
        fp.scriereRezolvari(c);
        for (Utilizator u : utilizatori) {
            if (u.getNume().equals(c.getUtilizator().getNume())) {
                u.getCereriSolutionate().add(c);
                for (Cerere cu : u.getCereriAsteptare()) {
                    if (cu.equals(c)) {
                        u.getCereriAsteptare().remove(cu);
                        break;
                    }
                }
                break;
            }
        }
        cereriAngajati.getCereri().remove(c);
        return cereriAngajati;
    }

    public Birou<Elev> cerereElev(Birou<Elev> cereriElevi, List<Utilizator> utilizatori,
                                        FunctionarPublic fp) {
        Cerere c = cereriElevi.getCereri().get(0);
        fp.scriereRezolvari(c);
        for (Utilizator u : utilizatori) {
            if (u.getNume().equals(c.getUtilizator().getNume())) {
                for (Cerere cu : u.getCereriAsteptare()) {
                    if (cu.equals(c)) {
                        u.getCereriSolutionate().add(c);
                        u.getCereriAsteptare().remove(cu);
                        break;
                    }
                }
                break;
            }
        }
        cereriElevi.getCereri().remove(c);
        return cereriElevi;
    }

    public Birou<EntitateJuridica> cerereEntitateJuridica(Birou<EntitateJuridica> cereriEntitatiJuridice,
                                                          List<Utilizator> utilizatori, FunctionarPublic fp) {
        Cerere c = cereriEntitatiJuridice.getCereri().get(0);
        fp.scriereRezolvari(c);
        for (Utilizator u : utilizatori) {
            if (u.getNume().equals(c.getUtilizator().getNume())) {
                u.getCereriSolutionate().add(c);
                for (Cerere cu : u.getCereriAsteptare()) {
                    if (cu.equals(c)) {
                        u.getCereriAsteptare().remove(cu);
                        break;
                    }
                }
                break;
            }
        }
        cereriEntitatiJuridice.getCereri().remove(c);
        return cereriEntitatiJuridice;
    }

    public Birou<Pensionar> cererePensionar(Birou<Pensionar> cereriPensionari, List<Utilizator> utilizatori,
                                  FunctionarPublic fp) {
        Cerere c = cereriPensionari.getCereri().get(0);
        fp.scriereRezolvari(c);
        for (Utilizator u : utilizatori) {
            if (u.getNume().equals(c.getUtilizator().getNume())) {
                u.getCereriSolutionate().add(c);
                for (Cerere cu : u.getCereriAsteptare()) {
                    if (cu.equals(c)) {
                        u.getCereriAsteptare().remove(cu);
                        break;
                    }
                }
                break;
            }
        }
        cereriPensionari.getCereri().remove(c);
        return cereriPensionari;
    }

    public Birou<Persoana> cererePersoana(Birou<Persoana> cereriPersoane, List<Utilizator> utilizatori,
                                            FunctionarPublic fp) {
        Cerere c = cereriPersoane.getCereri().get(0);
        fp.scriereRezolvari(c);
        for (Utilizator u : utilizatori) {
            if (u.getNume().equals(c.getUtilizator().getNume())) {
                u.getCereriSolutionate().add(c);
                for (Cerere cu : u.getCereriAsteptare()) {
                    if (cu.equals(c)) {
                        u.getCereriAsteptare().remove(cu);
                        break;
                    }
                }
                break;
            }
        }
        cereriPersoane.getCereri().remove(c);
        return cereriPersoane;
    }
}
