package money;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class FrancTest {
    private Money five = Money.franc(5);

    @DataProvider(name = "multiplication")
    private Object[][] provideObjectsForMultiplyTest() {
        return new Object[][] {
                {five.times(2), Money.franc(10)},
                {five.times(3), Money.franc(15)}
        };
    }

    @DataProvider(name = "equality")
    private Object[][] provideObjectsForEquality() {
        return new Object[][] {
                {true, Money.franc(5), Money.franc(5)},
                {false, Money.franc(7), Money.franc(5)},
                {false, Money.franc(4), null}
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
        Assert.assertEquals(Money.franc(1).currency(), "CHF");
    }
}