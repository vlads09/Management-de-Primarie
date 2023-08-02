package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Adauga {

    public ArrayList<Utilizator> utilizator(ArrayList<Utilizator> utilizatori, String[] data) {
        switch (data[1]) {
            case "angajat":
                utilizatori.add(new Angajat(data[3]));
                utilizatori.get(utilizatori.size() - 1).setNume(data[2]);
                break;

            case "elev":
                utilizatori.add(new Elev(data[3]));
                utilizatori.get(utilizatori.size() - 1).setNume(data[2]);
                break;

            case "entitate juridica":
                utilizatori.add(new EntitateJuridica(data[3]));
                utilizatori.get(utilizatori.size() - 1).setNume(data[2]);
                break;

            case "pensionar":
                utilizatori.add(new Pensionar());
                utilizatori.get(utilizatori.size() - 1).setNume(data[2]);
                break;

            case "persoana":
                utilizatori.add(new Persoana());
                utilizatori.get(utilizatori.size() - 1).setNume(data[2]);
                break;

            default: break;
        }
        return utilizatori;
    }

    public Birou<Angajat> cerereAngajat(Utilizator u, Birou<Angajat> cereriAngajati, String[] data,
                                              SimpleDateFormat formatter, FileWriter fw)
            throws ParseException, IOException {
        switch (data[2]) {
            case "inlocuire buletin" : cereriAngajati.adaugaCerere(u.creareaUneiCereri(
                    Cerere.CereriPosibile.INLOCUIRE_BULETIN, Byte.parseByte(data[4])
                    , formatter.parse(data[3])));
                break;
            case "inlocuire carnet de sofer" :
                cereriAngajati.adaugaCerere(u.creareaUneiCereri(
                        Cerere.CereriPosibile.INLOCUIRE_CARNET_DE_SOFER, Byte.parseByte(data[4]),
                        formatter.parse(data[3])));
                break;
            case "inregistrare venit salarial" :
                cereriAngajati.adaugaCerere(u.creareaUneiCereri(
                        Cerere.CereriPosibile.INREGISTRARE_VENIT_SALARIAL, Byte.parseByte(data[4]),
                        formatter.parse(data[3])));
                break;
            default : {
                try {
                    throw new ExceptieCerere("Utilizatorul de tip angajat nu poate inainta " +
                            "o cerere de tip " + data[2] + "\n");
                } catch (ExceptieCerere e) {
                    fw.write(e.eroare);
                }
                break;
            }
        }
        return cereriAngajati;
    }

    public Birou<Elev> cerereElev(Utilizator u, Birou<Elev> cereriElevi, String[] data,
                                              SimpleDateFormat formatter, FileWriter fw)
            throws ParseException, IOException {
        switch (data[2]) {
            case "inlocuire buletin" : cereriElevi.adaugaCerere(u.creareaUneiCereri(
                    Cerere.CereriPosibile.INLOCUIRE_BULETIN, Byte.parseByte(data[4])
                    , formatter.parse(data[3])));
                break;
            case "inlocuire carnet de elev" : {
                cereriElevi.adaugaCerere(u.creareaUneiCereri(
                        Cerere.CereriPosibile.INLOCUIRE_CARNET_DE_ELEV, Byte.parseByte(data[4]),
                        formatter.parse(data[3])));
                break;
            }
            default : {
                try {
                    throw new ExceptieCerere("Utilizatorul de tip elev nu poate inainta " +
                            "o cerere de tip " + data[2] + "\n");
                } catch (ExceptieCerere e) {
                    fw.write(e.eroare);
                }
                break;
            }
        }
        return cereriElevi;
    }

    public Birou<EntitateJuridica> cerereEntitateJuridica(Utilizator u, Birou<EntitateJuridica> cereriEntitatiJuridice,
                                                          String[] data, SimpleDateFormat formatter, FileWriter fw)
            throws ParseException, IOException {
        switch (data[2]) {
            case "creare act constitutiv" : cereriEntitatiJuridice.adaugaCerere(u.creareaUneiCereri(
                    Cerere.CereriPosibile.CREARE_ACT_CONSTITUTIV, Byte.parseByte(data[4])
                    , formatter.parse(data[3])));
                break;
            case "reinnoire autorizatie" : cereriEntitatiJuridice.adaugaCerere(u.creareaUneiCereri(
                    Cerere.CereriPosibile.REINNOIRE_AUTORIZATIE, Byte.parseByte(data[4])
                    , formatter.parse(data[3])));
                break;
            default : {
                try {
                    throw new ExceptieCerere("Utilizatorul de tip entitate juridica nu poate inainta " +
                            "o cerere de tip " + data[2] + "\n");
                } catch (ExceptieCerere e) {
                    fw.write(e.eroare);
                }
                break;
            }
        }
        return cereriEntitatiJuridice;
    }

    public Birou<Pensionar> cererePensionar(Utilizator u, Birou<Pensionar> cereriPensionari,
                                                          String[] data, SimpleDateFormat formatter, FileWriter fw)
            throws ParseException, IOException {
        switch (data[2]) {
            case "inlocuire buletin" : cereriPensionari.adaugaCerere(u.creareaUneiCereri(
                    Cerere.CereriPosibile.INLOCUIRE_BULETIN, Byte.parseByte(data[4])
                    , formatter.parse(data[3])));
                break;
            case "inlocuire carnet de sofer" :
                cereriPensionari.adaugaCerere(u.creareaUneiCereri(
                        Cerere.CereriPosibile.INLOCUIRE_CARNET_DE_SOFER, Byte.parseByte(data[4]),
                        formatter.parse(data[3])));
                break;
            case "inregistrare cupoane de pensie" :
                cereriPensionari.adaugaCerere(u.creareaUneiCereri(
                        Cerere.CereriPosibile.INREGISTRARE_CUPOANE_DE_PENSIE, Byte.parseByte(data[4]),
                        formatter.parse(data[3])));
                break;
            default : {
                try {
                    throw new ExceptieCerere("Utilizatorul de tip pensionar nu poate inainta " +
                            "o cerere de tip " + data[2] + "\n");
                } catch (ExceptieCerere e) {
                    fw.write(e.eroare);
                }
                break;
            }
        }
        return cereriPensionari;
    }

    public Birou<Persoana> cererePersoana(Utilizator u, Birou<Persoana> cereriPersoane,
                                            String[] data, SimpleDateFormat formatter, FileWriter fw)
            throws ParseException, IOException {
        switch (data[2]) {
            case "inlocuire buletin" : cereriPersoane.adaugaCerere(u.creareaUneiCereri(
                    Cerere.CereriPosibile.INLOCUIRE_BULETIN, Byte.parseByte(data[4])
                    , formatter.parse(data[3])));
                break;
            case "inlocuire carnet de sofer" :
                cereriPersoane.adaugaCerere(u.creareaUneiCereri(
                        Cerere.CereriPosibile.INLOCUIRE_CARNET_DE_SOFER, Byte.parseByte(data[4]),
                        formatter.parse(data[3])));
                break;
            default : {
                try {
                    throw new ExceptieCerere("Utilizatorul de tip persoana nu poate inainta " +
                            "o cerere de tip " + data[2] + "\n");
                } catch (ExceptieCerere e) {
                    fw.write(e.eroare);
                }
                break;
            }
        }
        return cereriPersoane;
    }
}
