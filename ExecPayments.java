import accounting.Payment;
import accounting.VATRate;

public class ExecPayments {
    public static void main(String[] args) {
        Payment myPayment = new ExpressBankTransfer();

        double netAmount = myPayment.perform(10.00); // Montant après frais bancaires
        double totalAmount = VATRate.STANDARD.calculateTotalAmount(netAmount);

        System.out.println("Net Amount (Excl. VAT): " + netAmount);
        System.out.println("Final Amount (Incl. VAT): " + totalAmount);
    }
}