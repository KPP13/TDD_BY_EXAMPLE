package money;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class FrancsDollarsCompareTest {
    @DataProvider(name = "francsDollars")
    private Object[][] provideMoneyObjects() {
        return new Object[][] {
                {true, new Dollar(5), new Dollar(5)},
                {false, new Dollar(6), new Dollar(5)},
                {true, new Franc(5), new Franc(5)},
                {false, new Franc(6), new Franc(5)},
                {false, new Dollar(5), new Franc(5)}
        };
    }

    @Test(dataProvider = "francsDollars")
    public void testFrancsDollarsComapare(boolean excepted, Money leftObj, Money rightObj) {
        Assert.assertEquals(leftObj.equals( rightObj ), excepted);
    }
}
