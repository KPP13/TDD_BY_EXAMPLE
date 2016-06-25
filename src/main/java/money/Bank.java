package money;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Pair, Integer> rates = new HashMap<>();

    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    int rate(String from, String to) {
        if (from.equals(to)) return 1;
        return rates.get(new Pair(from, to));
    }

    void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    private class Pair {
        private String from;
        private String to;

        Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null) return false;
            if (!this.getClass().equals( object.getClass() ))
                return false;
            Pair tmpPair = (Pair)object;
            return from.equals( tmpPair.from ) && to.equals( tmpPair.to );
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
