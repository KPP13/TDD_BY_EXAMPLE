package money;

class Franc {
    private int amount;

    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    // equals -> value object
    @Override
    public boolean equals(Object franc) {
        if (franc == null) return false;
        if (this == franc) return true;
        if (!this.getClass().equals( franc.getClass() ))
            return false;
        Franc francObject = (Franc)franc;
        return amount == francObject.amount;
    }
}