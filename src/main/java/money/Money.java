package money;

public abstract class Money {
    protected int amount;
    protected String currency;

    // equals -> value object
    @Override
    public boolean equals(Object money) {
        if (money == null) return false;
        if (this == money) return true;
        if (!this.getClass().equals( money.getClass() ))
            return false;
        Money moneyObject = (Money)money;
        return amount == moneyObject.amount;
    }

    // multiply method
    abstract Money times(int multiplier);

    // currency method
    String currency() {
        return currency;
    }

    // factory method for Dollar
    static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    // factory method for Franc
    static Franc franc(int amount) {
        return new Franc(amount, "CHF");
    }
}
