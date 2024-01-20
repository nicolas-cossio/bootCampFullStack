package clases;

import interfaces.Account;

public class CurrentAccount implements Account {
        double balance;

        public CurrentAccount() {
            balance = 0.0;
        }

        @Override
        public void consultBalance() {
            System.out.println("El saldo de la cuenta corriente es: "+balance);
        }

        @Override
        public void deposit(double amount) {
            double interest = calculateInterest();
            balance += amount*(1+interest);
            System.out.println("Deposito de "+amount+" a cuenta corriente");
        }

        @Override
        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("SALDO INSUFICIENTE! No se pudo retirar "+amount+" de la cuenta corriente");
                return;
            }
            balance -= amount;
            System.out.println("Retiro de "+amount+" de cuenta corriente");
        }

        @Override
        public double calculateInterest() {
            // Cuando es cuenta corriente, el interés es del 2%
            return 0.02;
        }
}
