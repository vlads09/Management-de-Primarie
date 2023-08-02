package org.example;

public class Persoana extends Utilizator {
    @Override
    String scriereCerere(Cerere.CereriPosibile tip) {
        if (tip.equals(Cerere.CereriPosibile.INLOCUIRE_BULETIN))
            return "Subsemnatul " + this.getNume() +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire buletin\n";
        else if (tip.equals(Cerere.CereriPosibile.INLOCUIRE_CARNET_DE_SOFER))
            return "Subsemnatul " + this.getNume() +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire carnet de sofer\n";
        return null;
    }
}
