package entities;

public class BusinessAccount extends Account {
    private Double loanLimit;

    public BusinessAccount() {
        super();    // boa prática caso ouver algo que deve ser mandando no construtor padrão
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance); // serve como se fosse instanciar um novo objeto do objeto pai desse objeto atual
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) {  // vê se a quantidade a ser emprestada pelo banco não supera o limite de impréstimo do user
            balance += amount - 10.0;
        }
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount); // vai até a classe pai e executa o método passando o valor desse método que ele está dentro
        balance -= 2.0;
    }
}