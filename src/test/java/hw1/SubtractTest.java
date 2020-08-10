package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest {

    private Calculator calc;

        @BeforeClass(alwaysRun = true)
        public void beforeClass() {
            calc = new Calculator();
        }

    @Test(groups = {"plusMinusGroup"}, dataProvider = "DataForSubtraction",
            dataProviderClass = DataProviders.class)
    public void subtractLongTest(long a, long b, long expectedRes) {

        assertEquals(calc.sub(a, b), expectedRes);
    }
}
