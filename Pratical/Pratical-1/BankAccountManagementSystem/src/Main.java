import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<LedgerEntry> ledger = new ArrayList<>();
    private static int transactionCounter = 1;

    private static void recordTransaction(String type, Money amount) {
        LedgerEntry entry = new LedgerEntry(
            "TXN" + transactionCounter++,
            type,
            amount,
            LocalDateTime.now().toString()
        );

        ledger.add(entry);
    }

    private static void showBalance(String label, BankAccount account) {
        double balance = account.getBalance().getAmountInPaise() / 100.0;
        System.out.printf("%s: INR %.2f%n", label, balance);
    }

    public static void main(String[] args) {

        System.out.println("===== BANK ACCOUNT MANAGEMENT SYSTEM =====");

        BankAccount accountA = new BankAccount(
            "1001",
            new Money(1_000_000L, "INR"),
            new Money(500_000L, "INR")
        );

        BankAccount accountB = new BankAccount(
            "1002",
            new Money(200_000L, "INR"),
            new Money(0L, "INR")
        );

        System.out.println("\n--- Initial Balances ---");
        showBalance("Account A", accountA);
        showBalance("Account B", accountB);

        System.out.println("\n--- Deposit ---");
        Money deposit = new Money(100_000L, "INR");
        accountA.deposit(deposit);
        recordTransaction("DEPOSIT - Account 1001", deposit);

        System.out.println("\n--- Withdrawal ---");
        Money withdrawal = new Money(50_000L, "INR");
        accountA.withdraw(withdrawal);
        recordTransaction("WITHDRAWAL - Account 1001", withdrawal);

        System.out.println("\n--- Freeze Account ---");
        accountA.freeze();

        try {
            accountA.withdraw(new Money(10_000L, "INR"));
        } catch (IllegalStateException e) {
            System.out.println("Withdrawal blocked: " + e.getMessage());
        }

        accountA.unfreeze();

        System.out.println("\n--- Overdraft Test ---");
        try {
            accountA.withdraw(new Money(2_000_000L, "INR"));
        } catch (IllegalStateException e) {
            System.out.println("Withdrawal blocked: " + e.getMessage());
        }

        System.out.println("\n--- Money Transfer ---");
        Money transferAmount = new Money(500_000L, "INR");

        FundTransfer transfer = new FundTransfer(
            "TRF001",
            accountA,
            accountB,
            transferAmount
        );

        transfer.transfer();

        recordTransaction("TRANSFER OUT - Account 1001", transferAmount);
        recordTransaction("TRANSFER IN - Account 1002", transferAmount);

        System.out.println("\n--- Close Account ---");
        accountB.close();

        try {
            accountB.withdraw(new Money(10_000L, "INR"));
        } catch (IllegalStateException e) {
            System.out.println("Withdrawal blocked: " + e.getMessage());
        }

        System.out.println("\n--- Final Balances ---");
        showBalance("Account A", accountA);
        showBalance("Account B", accountB);

        System.out.println("\n--- Transaction History ---");
        for (LedgerEntry entry : ledger) {
            entry.displayEntry();
            System.out.println("---------------------------");
        }

        System.out.println("\n===== PROGRAM COMPLETED =====");
    }
}
