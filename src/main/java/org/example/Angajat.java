package org.example;


public class Angajat extends Utilizator {
    private final String companie;

    public Angajat(String companie) {
        this.companie = companie;
    }

    public String getCompanie() {
        return companie;
    }

    @Override
    String scriereCerere(Cerere.CereriPosibile tip) {
        if (tip.equals(Cerere.CereriPosibile.INLOCUIRE_BULETIN))
            return "Subsemnatul " + this.getNume() + ", angajat la compania " + this.companie +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire buletin\n";
        else if (tip.equals(Cerere.CereriPosibile.INLOCUIRE_CARNET_DE_SOFER))
            return "Subsemnatul " + this.getNume() + ", angajat la compania " + this.companie +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire carnet de sofer\n";
        else if (tip.equals(Cerere.CereriPosibile.INREGISTRARE_VENIT_SALARIAL))
            return "Subsemnatul " + this.getNume() + ", angajat la compania " + this.companie +
                    ", va rog sa-mi aprobati urmatoarea solicitare: inregistrare venit salarial\n";
        return null;
    }
}
