package money;

class Dollar extends Money {
    Dollar(int amount) {
        this.amount = amount;
    }

    @Override
    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }
}
