import comptabilite.Paiement;
import comptabilite.TauxTVA;

public class ExecPaiement {
    public static void main(String[] args) {
        // Paiement modePaiement = new CarteBancaire();
        // Paiement modePaiement = new Virement();
        Paiement modePaiement = new VirementExpress();

        double montantHT = modePaiement.effectuer(10.00);

        double montantTTC = TauxTVA.STANDARD.calculerTTC(montantHT);

        System.out.println("Montant net (HT): " + montantHT);
        System.out.println("Montant final (TTC): " + montantTTC);
    }
}