package entities;

public class Account {
    public static double DEPOSIT_FEE_PERCENTAGE = 0.02;

    private Long id;
    private Double balance;

    public Account() {
    }

    public Account(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            amount = amount - (amount * DEPOSIT_FEE_PERCENTAGE);
            this.balance += amount;
        }
    }

    public void withdraw(double amount) throws IllegalAccessException {
        if (amount > balance) {
            throw new IllegalAccessException();
        }

        this.balance -= amount;
    }

    public double fullWithdraw() {
        double aux = this.balance;
        this.balance = 0.0;

        return aux;
    }
}