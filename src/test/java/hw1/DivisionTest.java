package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DivisionTest {

    private Calculator calc;

    @BeforeClass(alwaysRun = true)
    public void before_class() {
        calc = new Calculator();
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForDivision",
            dataProviderClass = DataProviders.class)
    public void divideLongTest(long a, long b, long expectedRes) {

        assertEquals(calc.div(a, b), expectedRes);
    }

    @Test(groups = {"multDivGroup"}, expectedExceptions = NumberFormatException.class)
    public void divideByZeroTest() {

        calc.div(2938476L, 0L);
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForDivisionDouble",
            dataProviderClass = DataProviders.class)
    public void divideDoubleTest(double a, double b, double expectedRes, double delta) {

        assertEquals(calc.div(a, b), expectedRes, delta);
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForInfDivDouble",
            dataProviderClass = DataProviders.class)
    public void infinityResultTest(double a, double b, double expectedRes) {

        assertTrue(Double.isInfinite(calc.div(a, b)));
        assertEquals(calc.div(a, b), expectedRes);
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForNaNDivDouble",
            dataProviderClass = DataProviders.class)
    public void nanResultTest(double a, double b) {

        assertTrue(Double.isNaN(calc.div(a, b)));
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForZeroDivDouble",
            dataProviderClass = DataProviders.class)
    public void zeroResultTest(double a, double b, double expectedRes) {

        assertEquals(calc.div(a, b), expectedRes);
    }


}
