package accounting;

public interface Payment {

    double perform(double amount) throws PaymentException;

    double getFees();

}