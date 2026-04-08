import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import accounting.Payment;
import accounting.VATRate;

public class ExecPayments {
    public static void main(String[] args) {

        List<Payment> transactionBatch = new ArrayList<>();

        transactionBatch.add(new CreditCard());
        transactionBatch.add(new BankTransfer());
        transactionBatch.add(new ExpressBankTransfer());
        transactionBatch.add(new CreditCard());

        double baseAmount = 100.0;
        double totalAmount = 0;

        System.out.println("=== Daily Transaction Report ===");
        System.out.println("Number of transactions: " + transactionBatch.size());
        System.out.println("--------------------------------");

        double streamTotal = transactionBatch.stream()
        // .filter(p -> p instanceof CreditCard)
        // For every payment, we calculate the base amount
        .mapToDouble(p -> VATRate.STANDARD.calculateTotalAmount(p.perform(baseAmount)))
        // We sum up everything
        .sum();

        double streamAverage = transactionBatch.stream()
        .mapToDouble(p -> VATRate.STANDARD.calculateTotalAmount(p.perform(baseAmount)))
        .average()
        .orElse(0.0);

        transactionBatch.stream().forEach(p -> {
            double total = VATRate.STANDARD.calculateTotalAmount(p.perform(baseAmount));
            
            System.out.println("Method: " + p.getClass().getSimpleName());
            System.out.println("Final amount to pay: " + total + " €");
            System.out.println("---");
        });

        System.out.println("Grand Total for the day : " + streamTotal + " €.");
        System.out.println("Average for the day : " + streamAverage + " €.");
    }
}