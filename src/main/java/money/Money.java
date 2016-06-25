package money;

public abstract class Money {
    protected int amount;

    abstract Money times(int multiplier);

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
}
