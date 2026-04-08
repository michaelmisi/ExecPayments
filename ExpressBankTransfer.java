public class ExpressBankTransfer extends BankTransfer {
    private double fixedFees = 10.00;

    @Override
    public double perform(double amount) {
        return amount + this.fixedFees;
    }

    @Override
    public double getFees() {
        return this.fixedFees;
    }
}