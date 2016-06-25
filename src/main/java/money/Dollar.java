package money;

class Dollar extends Money {
    Dollar(int amount, final String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }
}
