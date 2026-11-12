public class Money {

    private final long amountInPaise;
    private final String currency;

    public Money(long amountInPaise, String currency) {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency cannot be empty");
        }

        this.amountInPaise = amountInPaise;
        this.currency = currency;
    }

    public Money add(Money other) {
        validateCurrency(other);
        return new Money(
            Math.addExact(this.amountInPaise, other.amountInPaise),
            this.currency
        );
    }

    public Money subtract(Money other) {
        validateCurrency(other);
        return new Money(
            Math.subtractExact(this.amountInPaise, other.amountInPaise),
            this.currency
        );
    }

    public boolean isPositive() {
        return amountInPaise > 0;
    }

    private void validateCurrency(Money other) {
        if (other == null || !this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
    }

    public long getAmountInPaise() {
        return amountInPaise;
    }

    public String getCurrency() {
        return currency;
    }
}
