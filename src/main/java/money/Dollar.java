package money;

class Dollar {
    private int amount;

    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    // equals -> value object
    @Override
    public boolean equals(Object dollar) {
        if (dollar == null) return false;
        if (this == dollar) return true;
        if (!this.getClass().equals( dollar.getClass() ))
            return false;
        Dollar dollarObject = (Dollar)dollar;
        return amount == dollarObject.amount;
    }
}
