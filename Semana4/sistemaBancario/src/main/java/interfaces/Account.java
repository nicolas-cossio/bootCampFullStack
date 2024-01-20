package interfaces;

public interface Account {
    // Metodo para realizar depósitos
    void deposit(double amount);

    // Método para realizar retiros
    void withdraw(double amount);

    // Método para calcular el interes
    double calculateInterest();

    void consultBalance();
}
