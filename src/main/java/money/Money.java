package money;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // equals -> value object
    @Override
    public boolean equals(Object money) {
        if (money == null) return false;
        if (this == money) return true;
        //if (!this.getClass().equals( money.getClass() ))
        //   return false;
        Money moneyObject = (Money)money;
        return amount == moneyObject.amount && currency.equals( moneyObject.currency );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(amount).append(" ").append(currency).toString();
    }

    // multiply method
    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    // currency method
    String currency() {
        return currency;
    }

    // factory method for Dollar
    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    // factory method for Franc
    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    // addition
    Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    // reduce
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
