import java.math.BigDecimal;

public class Transaction {

    private Account debit;
    private Account credit;
    private double amount;

    public Transaction(Account debit, Account credit, double amount) {
        this.debit = debit;
        this.credit = credit;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Account getDebit() {
        return debit;
    }

    public Account getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "debit=" + debit +
                ", credit=" + credit +
                ", amount=" + amount +
                '}';
    }
}
