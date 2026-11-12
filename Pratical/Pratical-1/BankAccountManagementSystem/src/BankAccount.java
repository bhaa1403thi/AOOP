public class BankAccount {

    private final String accountNumber;
    private Money balance;
    private final Money overdraftLimit;
    private AccountStatus status;

    public BankAccount(String accountNumber,
                       Money balance,
                       Money overdraftLimit) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Invalid account number");
        }

        if (balance == null || overdraftLimit == null) {
            throw new IllegalArgumentException("Money values cannot be null");
        }

        if (!balance.getCurrency().equals(overdraftLimit.getCurrency())) {
            throw new IllegalArgumentException("Currency mismatch");
        }

        if (overdraftLimit.getAmountInPaise() < 0) {
            throw new IllegalArgumentException("Invalid overdraft limit");
        }

        if (balance.getAmountInPaise() < -overdraftLimit.getAmountInPaise()) {
            throw new IllegalArgumentException("Balance exceeds overdraft limit");
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
        this.status = AccountStatus.ACTIVE;
    }

    public void deposit(Money amount) {
        if (amount == null || !amount.isPositive()) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        if (status == AccountStatus.CLOSED) {
            throw new IllegalStateException("Account is closed");
        }

        balance = balance.add(amount);
        System.out.println("Deposit successful!");
    }

    public void withdraw(Money amount) {
        if (amount == null || !amount.isPositive()) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

        if (status != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Account is not active");
        }

        Money newBalance = balance.subtract(amount);

        if (newBalance.getAmountInPaise() < -overdraftLimit.getAmountInPaise()) {
            throw new IllegalStateException("Overdraft limit exceeded");
        }

        balance = newBalance;
        System.out.println("Withdrawal successful!");
    }

    public void freeze() {
        if (status != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Account cannot be frozen");
        }

        status = AccountStatus.FROZEN;
        System.out.println("Account frozen successfully!");
    }

    public void unfreeze() {
        if (status != AccountStatus.FROZEN) {
            throw new IllegalStateException("Account is not frozen");
        }

        status = AccountStatus.ACTIVE;
        System.out.println("Account unfrozen successfully!");
    }

    public void close() {
        if (status == AccountStatus.CLOSED) {
            throw new IllegalStateException("Account already closed");
        }

        status = AccountStatus.CLOSED;
        System.out.println("Account closed successfully!");
    }

    public Money getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountStatus getStatus() {
        return status;
    }
}
