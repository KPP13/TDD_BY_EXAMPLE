package money;

class Franc extends Money {
    Franc(int amount, final String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }
}