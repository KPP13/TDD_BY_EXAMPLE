package money;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class MoneyTest {
    private Money fiveDollars = Money.dollar(5);
    private Money fiveFrancs = Money.franc(5);

    @DataProvider(name = "multiplication")
    private Object[][] provideObjectsForMultiplyTest() {
        return new Object[][] {
                {fiveDollars.times(2), Money.dollar(10)},
                {fiveDollars.times(3), Money.dollar(15)},
                {fiveFrancs.times(2), Money.franc(10)},
                {fiveFrancs.times(3), Money.franc(15)}
        };
    }

    @DataProvider(name = "equality")
    private Object[][] provideObjectsForEquality() {
        return new Object[][] {
                {true, Money.dollar(5), Money.dollar(5)},
                {false, Money.dollar(7), Money.dollar(5)},
                {false, Money.dollar(4), null},
                {true, Money.franc(5), Money.franc(5)},
                {false, Money.franc(7), Money.franc(5)},
                {false, Money.franc(4), null},
                {true, Money.dollar(5), Money.dollar(5)},
                {false, Money.dollar(6), Money.dollar(5)},
                {true, Money.franc(5), Money.franc(5)},
                {false, Money.franc(6), Money.franc(5)},
                {false, Money.dollar(5), Money.franc(5)}
        };
    }

    @DataProvider(name = "money")
    private Object[][] provideBucksAndFrancs() {
        return new Object[][] {
                {Money.dollar(5), Money.franc(10)}
        };
    }

    @Test(dataProvider = "multiplication") // multiplication
    void testMultiplication(Money actual, Money excepted) {
        Assert.assertEquals(actual, excepted);
    }

    @Test(dataProvider = "equality") // equality
    void testEquality(boolean excepted, Money leftObj, Money rightObj) {
        Assert.assertEquals( leftObj.equals(rightObj), excepted );
    }

    @Test // currency
    public void currencyTest() {
        Assert.assertEquals(Money.dollar(1).currency(), "USD");
        Assert.assertEquals(Money.franc(1).currency(), "CHF");
    }

    @Test // addition
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        Assert.assertEquals(reduced, Money.dollar(10));
    }

    @Test // sum test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        Assert.assertEquals(sum.augend, five);
        Assert.assertEquals(sum.addend, five);
    }

    @Test // reduce
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        Assert.assertEquals(result, Money.dollar(7));
    }

    @Test // reduce money
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        Assert.assertEquals(result, Money.dollar(1));
    }

    @Test // different currencies
    public void testDifferentCurrencies() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce( Money.franc(2), "USD" );
        Assert.assertEquals( Money.dollar(1), result );
    }

    @Test // identity rate
    public void testIdentityRate() {
        Assert.assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test(dataProvider = "money") // mixed
    public void testMixedAddition(Expression fiveBucks, Expression tenFrancs) {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        Assert.assertEquals(result, Money.dollar(10));
    }

    @Test(dataProvider = "money") // sum -> plus
    public void testSumPlusMoney(Expression fiveBucks, Expression tenFrancs) {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus( fiveBucks );
        Money result = bank.reduce(sum, "USD");
        Assert.assertEquals(result, Money.dollar(15));
    }

    @Test(dataProvider = "money") // test sum times
    public void testSumTimes(Expression fiveBucks, Expression tenFrancs) {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(20), result);
    }

    @Test  // check instance
    public void testPlusSameCurrencyReturnsMoney() {
        Expression sum = Money.dollar(1).plus( Money.dollar(1) );
        Assert.assertTrue(sum instanceof Sum);
    }
}
