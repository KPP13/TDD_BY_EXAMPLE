package money;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class FrancsDollarsCompareTest {
    @DataProvider(name = "francsDollars")
    private Object[][] provideMoneyObjects() {
        return new Object[][] {
                {true, Money.dollar(5), Money.dollar(5)},
                {false, Money.dollar(6), Money.dollar(5)},
                {true, Money.franc(5), Money.franc(5)},
                {false, Money.franc(6), Money.franc(5)},
                {false, Money.dollar(5), Money.franc(5)}
        };
    }

    @Test(dataProvider = "francsDollars")
    public void testFrancsDollarsCompare(boolean excepted, Money leftObj, Money rightObj) {
        Assert.assertEquals(leftObj.equals( rightObj ), excepted);
    }
}
