package money;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class FrancTest {
    private Franc five = new Franc(5);

    @DataProvider(name = "multiplication")
    private Object[][] provideObjectsForMultiplyTest() {
        return new Object[][] {
                {five.times(2), new Franc(10)},
                {five.times(3), new Franc(15)}
        };
    }

    @DataProvider(name = "equality")
    private Object[][] provideObjectsForEquality() {
        return new Object[][] {
                {true, new Franc(5), new Franc(5)},
                {false, new Franc(7), new Franc(5)},
                {false, new Franc(4), null}
        };
    }

    @Test(dataProvider = "multiplication") // multiplication
    void testMultiplication(Franc actual, Franc excepted) {
        Assert.assertEquals(actual, excepted);
    }



    @Test(dataProvider = "equality") // equality
    void testEquality(boolean excepted, Franc leftObj, Franc rightObj) {
        Assert.assertEquals( leftObj.equals(rightObj), excepted );
    }
}