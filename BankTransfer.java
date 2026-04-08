import accounting.Payment;

public class BankTransfer implements Payment {
    protected double feePercent = 0.00; // 'protected' pour que l'enfant puisse y accéder si besoin

    @Override
    public double perform(double amount) {
        return amount + (amount * feePercent);
    }

    @Override
    public double getFees() {
        return feePercent;
    }
}