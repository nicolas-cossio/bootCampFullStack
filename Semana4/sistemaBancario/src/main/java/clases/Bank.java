package clases;

import interfaces.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts = new ArrayList<>();

    public Bank() {
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    // Método para agregar cuentas a la lista del banco
    public void addAccount(Account account) {
        accounts.add(account);
    }
}
