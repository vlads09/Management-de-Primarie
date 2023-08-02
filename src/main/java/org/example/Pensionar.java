package org.example;

public class Pensionar extends Utilizator {
    @Override
    String scriereCerere(Cerere.CereriPosibile tip) {
        if (tip.equals(Cerere.CereriPosibile.INLOCUIRE_BULETIN))
            return "Subsemnatul " + this.getNume() +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire buletin\n";
        else if (tip.equals(Cerere.CereriPosibile.INLOCUIRE_CARNET_DE_SOFER))
            return "Subsemnatul " + this.getNume() +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire carnet de sofer\n";
        else if (tip.equals(Cerere.CereriPosibile.INREGISTRARE_CUPOANE_DE_PENSIE))
            return "Subsemnatul " + this.getNume() +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inregistrare cupoane de pensie\n";
        return null;
    }
}
