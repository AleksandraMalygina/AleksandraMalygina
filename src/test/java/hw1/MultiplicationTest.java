package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationTest {

    private Calculator calc;

    @BeforeClass(alwaysRun = true)
    public void before_class() {
        calc = new Calculator();
    }

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForMultiplication",
            dataProviderClass = DataProviders.class)
    void multiplyLongTest(long a, long b, long expectedRes) {

        assertEquals(calc.mult(a, b), expectedRes);
    }

}
