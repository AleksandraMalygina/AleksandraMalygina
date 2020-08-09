package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationTest {

    private Calculator calc = new Calculator();

    @Test(groups = {"multDivGroup"}, dataProvider = "DataForMultiplication",
            dataProviderClass = DataProviders.class)
    void multiplyLongTest(Object[] l) {
        Long a = (Long) l[0];
        Long b = (Long) l[1];
        Long expectedRes = (Long) l[2];

        assertEquals(java.util.Optional.of(calc.mult(a, b)).get(), expectedRes);
    }

}
