package accounting;

// On hérite de Exception pour créer une "Checked Exception"
// (Java nous obligera à la gérer, c'est une sécurité)
public class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}
