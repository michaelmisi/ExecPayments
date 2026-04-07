import comptabilite.Paiement;

public class Virement implements Paiement {
    @Override
    public double effectuer(double montant){
        return montant;
    }
}
