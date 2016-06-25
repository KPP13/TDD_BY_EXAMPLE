package dollar;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test()
public class DollarTest {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product1 = five.times(2);
        Assert.assertEquals(product1.amount, 10);
        Dollar product2 = five.times(3);
        Assert.assertEquals(product2.amount, 15);
    }
}
