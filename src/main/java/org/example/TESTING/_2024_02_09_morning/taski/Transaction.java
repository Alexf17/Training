package org.example.TESTING._2024_02_09_morning.taski;

public class Transaction {
    private final double amount;
    private final boolean isSuccess;

    public Transaction(double amount, boolean isSuccess) {
        this.amount = amount;
        this.isSuccess = isSuccess;
    }

    public double getAmount() {return amount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
