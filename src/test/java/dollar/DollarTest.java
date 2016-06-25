package dollar;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class DollarTest {
    @Test // multiplication
    void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product1 = five.times(2);
        Assert.assertEquals(product1.amount, 10);
        Dollar product2 = five.times(3);
        Assert.assertEquals(product2.amount, 15);
    }

    @DataProvider(name = "equality")
    private Object[][] provideObjectsForEquality() {
        return new Object[][] {
                {true, new Dollar(5), new Dollar(5)},
                {false, new Dollar(7), new Dollar(5)},
                {false, new Dollar(4), null}
        };
    }

    @Test(dataProvider = "equality") // equality
    void testEquality(boolean excepted, Dollar leftObj, Dollar rightObj) {
        Assert.assertEquals( leftObj.equals(rightObj), excepted );
    }
}
