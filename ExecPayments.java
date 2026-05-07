import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import accounting.Payment;
import accounting.PaymentException;
import accounting.VATRate;

public class ExecPayments {
    public static void main(String[] args) {

        Scanner globalScanner = new Scanner(System.in);

        // --- 1. Intialisation du Grand LIvre (LEDGER) ---
        // On associe un nom de client à son mode de de paiements
        Map<String, Payment> ledger = new HashMap<>();

        ledger.put("Michael", new CreditCard());
        ledger.put("Ornella", new BankTransfer());
        ledger.put("Grazie", new ExpressBankTransfer());



        // --- 2. Fonctionnalité de récupération (get). ---
        // double transactionAmount = -50.0; // Simulation : une erreur de saisie !!!

        // --- Get the client's information
        System.out.println("Please enter client's name :");
        String clientName = globalScanner.nextLine();
        clientName = Utilities.capitalize(clientName);

        System.out.println("Please enter client's transaction amount :");
        double transactionAmount = 0;

        if(globalScanner.hasNextDouble()){
            transactionAmount = globalScanner.nextDouble();
        } else {
            System.err.println("Error : This is not a valid double");
        }
        // -------------------------------

        if(ledger.containsKey(clientName)){
            Payment p = ledger.get(clientName);
            System.out.println("Client: " + clientName);
            System.out.println("Payment mode: " + p.getClass().getSimpleName());

            // Payment simulator
            try {
                double result = p.perform(transactionAmount);
                System.out.println("Amount after fees : " + result + "€");
            } catch(PaymentException e) {
                System.err.println("ALERT: Transaction failed ! Reason: " + e.getMessage());
            } finally {
                System.out.println("Logging transaction attempt in security logs...");
            }

        }
        else {
            System.out.println("Client " + clientName + " not found in ledger.");
        }

        System.out.println("-------------------------------------------------------");



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
        .mapToDouble(p -> {
            try {
                return VATRate.STANDARD.calculateTotalAmount(p.perform(baseAmount));
            } catch (PaymentException e){
                System.err.println("Stream Error: " + e.getMessage());
                return 0.0;
            }
        })
        // We sum up everything
        .sum();

        double streamAverage = transactionBatch.stream()
        .mapToDouble(p -> {
            try {
                return VATRate.STANDARD.calculateTotalAmount(p.perform(baseAmount));
            } catch (PaymentException e) {
                System.err.println("Stream error " + e.getMessage());
                return 0.0;
            }
        })
        .average()
        .orElse(0.0);

        transactionBatch.stream().forEach(p -> {
            try {
                double total = VATRate.STANDARD.calculateTotalAmount(p.perform(baseAmount));

                System.out.println("Method: " + p.getClass().getSimpleName());
                System.out.println("Final amount to pay: " + total + " €");
                System.out.println("---");
            } catch (Exception e) {
                System.err.println("Cannot display " + p.getClass().getSimpleName() + ": " + e.getMessage());
            }
        });

        System.out.println("Grand Total for the day : " + streamTotal + " €.");
        System.out.println("Average for the day : " + streamAverage + " €.");

        globalScanner.close();
    }
}