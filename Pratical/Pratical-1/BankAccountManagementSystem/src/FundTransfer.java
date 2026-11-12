public class FundTransfer {

    private final String transferId;
    private final BankAccount source;
    private final BankAccount destination;
    private final Money amount;

    public FundTransfer(String transferId,
                        BankAccount source,
                        BankAccount destination,
                        Money amount) {

        if (transferId == null || transferId.isBlank()) {
            throw new IllegalArgumentException("Invalid transfer ID");
        }

        if (source == null || destination == null || amount == null) {
            throw new IllegalArgumentException("Invalid transfer details");
        }

        if (source == destination) {
            throw new IllegalArgumentException(
                "Source and destination cannot be the same"
            );
        }

        if (!amount.isPositive()) {
            throw new IllegalArgumentException("Invalid transfer amount");
        }

        if (!source.getBalance().getCurrency()
                .equals(destination.getBalance().getCurrency())
            || !source.getBalance().getCurrency()
                .equals(amount.getCurrency())) {
            throw new IllegalArgumentException("Currency mismatch");
        }

        if (destination.getStatus() == AccountStatus.CLOSED) {
            throw new IllegalStateException("Destination account is closed");
        }

        this.transferId = transferId;
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    public void transfer() {
        // The withdrawal must succeed before the destination is credited.
        source.withdraw(amount);

        try {
            destination.deposit(amount);
            System.out.println("Transfer successful!");
            System.out.println("Transfer ID: " + transferId);
        } catch (RuntimeException e) {
            // Compensate for a failed credit in this in-memory demonstration.
            source.deposit(amount);
            throw new IllegalStateException(
                "Transfer failed. Source debit reversed.", e
            );
        }
    }
}
