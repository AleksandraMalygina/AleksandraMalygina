package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest {

    private Calculator calc = new Calculator();

    //    @BeforeClass
    //    public void beforeClass(){
    //        calc = new Calculator();
    //    }

    @Test(groups = {"plusMinusGroup"}, dataProvider = "DataForSum",
            dataProviderClass = DataProviders.class)
    public void sumLongTest(Object[] l) {
        Long a = (Long) l[0];
        Long b = (Long) l[1];
        Long expectedRes = (Long) l[2];

        assertEquals(java.util.Optional.of(calc.sum(a, b)).get(), expectedRes);
    }
}
