package org.example;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class ManagementPrimarie {

    public static void main(String[] args) throws IOException, ParseException {
        // Your code here
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);

        ArrayList<Utilizator> utilizatori = new ArrayList<>();
        ArrayList<FunctionarPublic> functionari = new ArrayList<>();

        Birou<Angajat> cereriAngajati = new Birou<>(new Angajat("Primarie"));
        Birou<Elev> cereriElevi = new Birou<>(new Elev("Primarie"));
        Birou<EntitateJuridica> cereriEntitatiJuridice = new Birou<>(new EntitateJuridica("Primarie"));
        Birou<Pensionar> cereriPensionari = new Birou<>(new Pensionar());
        Birou<Persoana> cereriPersoane = new Birou<>(new Persoana());

        Adauga adauga = new Adauga();
        Afisari afisare = new Afisari();
        Retragere retragere = new Retragere();
        Rezolva rezolva = new Rezolva();

        File myObj = new File("src/main/resources/output/" + args[0]);
        //noinspection ResultOfMethodCallIgnored
        myObj.createNewFile();
        try (FileWriter fw = new FileWriter("src/main/resources/output/" + args[0], true)) {
            File f = new File("src/main/resources/input/" + args[0]);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split("; ");

                switch (data[0]) {
                    case "adauga_utilizator":
                        utilizatori = adauga.utilizator(utilizatori, data);
                        break;
                    case "cerere_noua":
                        for (Utilizator u : utilizatori) {
                            if (data[1].equals(u.getNume())) {
                                if (u instanceof Angajat) {
                                    cereriAngajati = adauga.cerereAngajat(u, cereriAngajati, data, formatter, fw);
                                } else if (u instanceof Elev) {
                                    cereriElevi = adauga.cerereElev(u, cereriElevi, data, formatter, fw);
                                } else if (u instanceof EntitateJuridica) {
                                    cereriEntitatiJuridice = adauga.cerereEntitateJuridica(u, cereriEntitatiJuridice,
                                            data, formatter, fw);
                                } else if (u instanceof Pensionar) {
                                    cereriPensionari = adauga.cererePensionar(u, cereriPensionari, data, formatter,
                                            fw);
                                } else if (u instanceof Persoana) {
                                    cereriPersoane = adauga.cererePersoana(u, cereriPersoane, data, formatter, fw);
                                }
                                break;
                            }
                        }
                        break;
                    case "afiseaza_cereri_in_asteptare":
                        afisare.cereriAsteptare(utilizatori, data, fw);
                        break;
                    case "retrage_cerere":
                        for (Utilizator u : utilizatori) {
                            if (u.getNume().equals(data[1])) {
                                int rez = u.retragereaUneiCereri(data[2]);
                                if (rez == 1) {
                                    if (u instanceof Angajat) {
                                        cereriAngajati = retragere.cerereAngajat(cereriAngajati, data, formatter);
                                    } else if (u instanceof Elev) {
                                        cereriElevi = retragere.cerereElev(cereriElevi, data, formatter);
                                    } else if (u instanceof EntitateJuridica) {
                                        cereriEntitatiJuridice =
                                                retragere.cerereEntitateJuridica(cereriEntitatiJuridice,
                                                        data, formatter);
                                    } else if (u instanceof Pensionar) {
                                        cereriPensionari = retragere.cererePensionar(cereriPensionari, data,
                                                formatter);
                                    } else if (u instanceof Persoana) {
                                        cereriPersoane = retragere.cererePersoana(cereriPersoane, data,
                                                formatter);
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    case "afiseaza_cereri":
                        afisare.cereri(cereriAngajati, cereriElevi, cereriEntitatiJuridice, cereriPensionari,
                                cereriPersoane, data, fw);
                        break;
                    case "adauga_functionar":
                        functionari.add(new FunctionarPublic(data[2], data[1]));
                        break;
                    case "rezolva_cerere":
                        for (FunctionarPublic fp : functionari) {
                            if (data[2].equals(fp.getNume())) {
                                switch (data[1]) {
                                    case "angajat":
                                        cereriAngajati = rezolva.cerereAngajat(cereriAngajati, utilizatori, fp);
                                        break;
                                    case "elev":
                                        cereriElevi = rezolva.cerereElev(cereriElevi, utilizatori, fp);
                                        break;
                                    case "entitate juridica":
                                        cereriEntitatiJuridice =
                                                rezolva.cerereEntitateJuridica(cereriEntitatiJuridice,
                                                        utilizatori, fp);
                                        break;
                                    case "pensionar":
                                        cereriPensionari = rezolva.cererePensionar(cereriPensionari,
                                                utilizatori, fp);
                                        break;
                                    case "persoana":
                                        cereriPersoane = rezolva.cererePersoana(cereriPersoane, utilizatori, fp);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            }
                        }
                        break;
                    case "afiseaza_cereri_finalizate":
                        afisare.cereriFinalizate(utilizatori, data, fw);
                        break;

                    default: break;
                }

            }
            myReader.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}