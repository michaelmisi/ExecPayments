import comptabilite.Paiement;

public class CarteBancaire implements Paiement {
    double frais = 0.05;

    @Override
    public double effectuer(double montant){

        return montant + (montant * frais);
    }
}

