package money;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class DollarTest {
    private Money five = Money.dollar(5);

    @DataProvider(name = "multiplication")
    private Object[][] provideObjectsForMultiplyTest() {
        return new Object[][] {
                {five.times(2), Money.dollar(10)},
                {five.times(3), Money.dollar(15)}
        };
    }

    @DataProvider(name = "equality")
    private Object[][] provideObjectsForEquality() {
        return new Object[][] {
                {true, Money.dollar(5), Money.dollar(5)},
                {false, Money.dollar(7), Money.dollar(5)},
                {false, Money.dollar(4), null}
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
    }
}
