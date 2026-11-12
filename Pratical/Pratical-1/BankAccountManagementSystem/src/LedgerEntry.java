public class LedgerEntry {

    private final String transactionId;
    private final String transactionType;
    private final Money amount;
    private final String timestamp;

    public LedgerEntry(String transactionId,
                       String transactionType,
                       Money amount,
                       String timestamp) {

        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("Invalid transaction ID");
        }

        if (transactionType == null || transactionType.isBlank()) {
            throw new IllegalArgumentException("Invalid transaction type");
        }

        if (amount == null || !amount.isPositive()) {
            throw new IllegalArgumentException("Invalid transaction amount");
        }

        if (timestamp == null || timestamp.isBlank()) {
            throw new IllegalArgumentException("Invalid timestamp");
        }

        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Money getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void displayEntry() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Transaction Type: " + transactionType);
        System.out.println(
            "Amount: " + amount.getAmountInPaise() / 100.0
            + " " + amount.getCurrency()
        );
        System.out.println("Timestamp: " + timestamp);
    }
}
