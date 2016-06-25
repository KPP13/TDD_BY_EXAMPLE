package dollar;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class DollarTest {
    private Dollar five = new Dollar(5);

    @DataProvider(name = "multiplication")
    private Object[][] provideObjectsForMultiplyTest() {
        return new Object[][] {
                {five.times(2), new Dollar(10)},
                {five.times(3), new Dollar(15)}
        };
    }

    @DataProvider(name = "equality")
    private Object[][] provideObjectsForEquality() {
        return new Object[][] {
                {true, new Dollar(5), new Dollar(5)},
                {false, new Dollar(7), new Dollar(5)},
                {false, new Dollar(4), null}
        };
    }

    @Test(dataProvider = "multiplication") // multiplication
    void testMultiplication(Dollar actual, Dollar excepted) {
        Assert.assertEquals(actual, excepted);
    }



    @Test(dataProvider = "equality") // equality
    void testEquality(boolean excepted, Dollar leftObj, Dollar rightObj) {
        Assert.assertEquals( leftObj.equals(rightObj), excepted );
    }
}
