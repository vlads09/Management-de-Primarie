package org.example;

public class EntitateJuridica extends Utilizator {
    private final String reprezentant;

    public EntitateJuridica(String reprezentant) {
        this.reprezentant = reprezentant;
    }
    public String getReprezentant() {
        return reprezentant;
    }

    @Override
    String scriereCerere(Cerere.CereriPosibile tip) {
        if (tip.equals(Cerere.CereriPosibile.CREARE_ACT_CONSTITUTIV))
            return "Subsemnatul " + this.reprezentant + ", reprezentant legal al companiei " + this.getNume() +
                    ", va rog sa-mi aprobati urmatoarea solicitare: creare act constitutiv\n";
        else if (tip.equals(Cerere.CereriPosibile.REINNOIRE_AUTORIZATIE))
            return "Subsemnatul " + this.reprezentant + ", reprezentant legal al companiei " + this.getNume() +
                    ", va rog sa-mi aprobati urmatoarea solicitare: reinnoire autorizatie\n";
        return null;
    }
}
