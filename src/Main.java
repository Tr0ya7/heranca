import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1001, "Alex", 0.0);
        BusinessAccount businessAccount = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING
        Account account1 = businessAccount;
        Account account2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account account3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
        // account2.loan(100.0);    não permitido fazer

        //DOWNCASTING
        BusinessAccount businessAccount1 = (BusinessAccount) account2;
        businessAccount1.loan(100.0);
        // BusinessAccount businessAccount2 = (BusinessAccount) account3;   Erro pois o objeto não é do tipo BusinessAccount, esse erro é alertado somente em tempo de execução
        if (account3 instanceof BusinessAccount) {  // vê se realmente o tipo do objeto é de uma BusinessAccount utilizando para isso instanceof
            BusinessAccount businessAccount2 = (BusinessAccount) account3;
            businessAccount2.loan(200.0);
            System.out.println("Loan!");
        } else if (account3 instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) account3;
            savingsAccount.updateBalance();
            System.out.println("Update!");
        }
    }
}