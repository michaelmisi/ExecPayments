import accounting.Payment;
import accounting.PaymentException;

public class CreditCard implements Payment {
    double feePercent = 0.05;

    @Override
    public double perform(double amount) throws PaymentException {

        if(amount <= 0){
            throw new PaymentException("Invalid amount: must be positive.");
        }
        if(amount > 5000){
            throw new PaymentException("Amount exceeds credit card limit.");
        }

        return amount + (amount * feePercent);
    }

    @Override
    public double getFees(){
        return feePercent;
    }
}
