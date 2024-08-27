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
        System.out.println();

        Account account4 = new Account(1005, "Alex", 1000.0);
        account4.withdraw(200.0);
        System.out.println(account4.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(1006, "Maria", 1000.0, 0.01);
        savingsAccount.withdraw(200.0);
        System.out.println(savingsAccount.getBalance());
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Account account5 = new Account(1005, "Alex", 1000.0);
        account5.withdraw(200.0);
        System.out.println(account5.getBalance());

        BusinessAccount businessAccount2 = new BusinessAccount(1006, "test", 10000.0, 100.0);
        businessAccount2.withdraw(900.0);
        System.out.println(businessAccount2.getBalance());
    }
}