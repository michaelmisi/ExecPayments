public class VirementExpress extends Virement {
    double frais = 10.00;

    @Override
    public double effectuer(double montant) {
        return montant + this.frais;
    }
}
