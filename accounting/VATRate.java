package accounting; // On remplace comptabilite par accounting

public enum VATRate {
    REDUCED(0.06),
    STANDARD(0.21);

    private final double rate; // 'final' car le taux d'une constante ne change pas

    VATRate(double rate) {
        this.rate = rate;
    }

    public double calculateTotalAmount(double netAmount) {
        return netAmount * (1 + this.rate);
    }
}