package dollar;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test()
public class DollarTest {


    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        Assert.assertEquals(five.amount, 10);
    }
}
