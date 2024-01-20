import clases.Bank;
import clases.CurrentAccount;
import clases.SavingsAccount;

public class app {
    public static void main(String[] args) {
        Bank bcp = new Bank();
        SavingsAccount savings = new SavingsAccount();
        CurrentAccount current = new CurrentAccount();

        // Se agregan las cuentas al banco
        bcp.addAccount(savings);
        bcp.addAccount(current);

        // Consultamos los saldos de las cuentas antes de las operaciones
        savings.consultBalance();
        current.consultBalance();

        // Operaciones con las cuentas
        savings.deposit(1000);
        savings.deposit(2000);
        savings.withdraw(500);

        current.deposit(1000);
        current.withdraw(500);

        // Consultamos los saldos de las cuentas luego de las operaciones
        savings.consultBalance();
        current.consultBalance();
    }
}
