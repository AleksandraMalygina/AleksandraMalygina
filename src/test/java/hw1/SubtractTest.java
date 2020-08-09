package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest {

    private Calculator calc = new Calculator();

    //    @BeforeClass
    //    public static void beforeClass(){
    //        System.out.println("BEFORE CLASS");
    //        calc = new Calculator();
    //    }

    @Test(groups = {"plusMinusGroup"}, dataProvider = "DataForSubtraction",
            dataProviderClass = DataProviders.class)
    public void subtractLongTest(Object[] l) {
        Long a = (Long) l[0];
        Long b = (Long) l[1];
        Long expectedRes = (Long) l[2];

        assertEquals(java.util.Optional.of(calc.sub(a, b)).get(), expectedRes);
    }
}
