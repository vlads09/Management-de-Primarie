package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FunctionarPublic {
    private final String nume;
    private final String tipUtilizator;

    public FunctionarPublic(String nume, String tipUtilizator) {
        this.nume = nume;
        this.tipUtilizator = tipUtilizator;
    }

    public String getNume() {
        return nume;
    }

    public String getTipUtilizator() {
        return tipUtilizator;
    }


    public void scriereRezolvari(Cerere c) {
        try {
            File myObj = new File("src/main/resources/output/" + "functionar_" + this.nume + ".txt");
            //noinspection ResultOfMethodCallIgnored
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter("src/main/resources/output/" + "functionar_" + this.nume + ".txt",
                true)) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
            fw.write(formatter.format(c.getData()) + " - " + c.getUtilizator().getNume() + "\n");

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
