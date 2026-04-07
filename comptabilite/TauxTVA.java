package comptabilite;

public enum TauxTVA {
    REDUIT(0.06),
    STANDARD(0.21);

    private double taux;

    // Constructeur (Toujours privé ou package-private pour un Enum)
    TauxTVA(double t){
        this.taux = t;
    }

    public double calculerTTC(double montantHT){
        // Calcule le montant TTC (HT * (1 + taux))
        return montantHT * (1 + this.taux);
    }
}