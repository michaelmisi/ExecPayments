package accounting;

public interface Payment {

    double perform(double amount);
    
    double getFees();

}