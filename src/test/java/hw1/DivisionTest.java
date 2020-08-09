package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DivisionTest {

    private Calculator calc = new Calculator();

    //    @BeforeTest
    //    public void before_class(){
    //         calc = new Calculator();
    //    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForDivision",
            dataProviderClass = DataProviders.class)
    public void divideLongTest(Object[] l) {
        Long a = (Long) l[0];
        Long b = (Long) l[1];
        Long expectedRes = (Long) l[2];

        assertEquals(java.util.Optional.of(calc.div(a, b)).get(), expectedRes);
    }

    @Test(groups = {"multDivGroup"}, expectedExceptions = NumberFormatException.class)
    public void divideByZeroTest() {
        calc.div(2938476L, 0L);
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForDivisionDouble",
            dataProviderClass = DataProviders.class)
    public void divideDoubleTest(Object[] l) {
        Double a = (Double) l[0];
        Double b = (Double) l[1];
        Double expectedRes = (Double) l[2];
        Double delta = (Double) l[3];

        assertEquals(calc.div(a, b), expectedRes, delta);
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForInfDivDouble",
            dataProviderClass = DataProviders.class)
    public void infinityResultTest(Object[] l) {
        Double a = (Double) l[0];
        Double b = (Double) l[1];
        Double expectedRes = (Double) l[2];

        assertTrue(Double.isInfinite(calc.div(a, b)));
        assertEquals(calc.div(a, b), expectedRes);
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForNaNDivDouble",
            dataProviderClass = DataProviders.class)
    public void nanResultTest(Object[] l) {
        Double a = (Double) l[0];
        Double b = (Double) l[1];

        assertTrue(Double.isNaN(calc.div(a, b)));
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForZeroDivDouble",
            dataProviderClass = DataProviders.class)
    public void zeroResultTest(Object[] l) {
        Double a = (Double) l[0];
        Double b = (Double) l[1];
        Double expectedRes = (Double) l[2];

        assertEquals(calc.div(a, b), expectedRes);
    }


}
