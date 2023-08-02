package org.example;

public class Elev extends Utilizator {
    String scoala;

    public Elev(String scoala) {
        this.scoala = scoala;
    }

    public String getScoala() {
        return scoala;
    }

    @Override
    String scriereCerere(Cerere.CereriPosibile tip) {
        if (tip.equals(Cerere.CereriPosibile.INLOCUIRE_BULETIN))
            return "Subsemnatul " + this.getNume() + ", elev la scoala " + this.scoala +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire buletin\n";
        else if (tip.equals(Cerere.CereriPosibile.INLOCUIRE_CARNET_DE_ELEV))
            return "Subsemnatul " + this.getNume() + ", elev la scoala " + this.scoala +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire carnet de elev\n";
        return null;
    }
}
