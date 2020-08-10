package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest {

    private Calculator calc;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        calc = new Calculator();
    }

    @Test(groups = {"plusMinusGroup"}, dataProvider = "DataForSum",
            dataProviderClass = DataProviders.class)
    public void sumLongTest(long a, long b, long expectedRes) {

        assertEquals(calc.sum(a, b), expectedRes);
    }
}
