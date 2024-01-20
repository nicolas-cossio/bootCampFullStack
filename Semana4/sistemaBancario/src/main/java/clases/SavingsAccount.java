package clases;

import interfaces.Account;

public class SavingsAccount implements Account {
    double balance;

    public SavingsAccount() {
        balance = 0.0;
    }

    @Override
    public void consultBalance() {
        System.out.println("El saldo de la cuenta de ahorros es: "+balance);
    }

    @Override
    public void deposit(double amount) {
        double interest = calculateInterest();
        balance += amount*(1+interest);
        System.out.println("Depósito de "+amount+" a cuenta de ahorros");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("SALDO INSUFICIENTE! No se pudo retirar "+amount+" de la cuenta de ahorros");
            return;
        }
        balance -= amount;
        System.out.println("Retiro de "+amount+" de cuenta de ahorros");
    }

    @Override
    public double calculateInterest() {
        // Cuando es cuenta de ahorros, el interés es del 3%
        return 0.03;
    }
}
