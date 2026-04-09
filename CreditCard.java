import accounting.Payment;

public class CreditCard implements Payment {
    double feePercent = 0.05;

    @Override
    public double perform(double amount){

        return amount + (amount * feePercent);
    }

    @Override
    public double getFees(){
        return feePercent;
    }
}

