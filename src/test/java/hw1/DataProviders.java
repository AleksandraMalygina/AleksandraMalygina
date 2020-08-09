package hw1;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "DataForSum")
    public static Object[][] getDataForSumOperation() {

        // Test cases:
        // zero/zero, zero/pos, pos/zero, pos/pos, neg/neg, neg/pos, pos/neg, neg/pos(equal),
        // pos/neg(equal),
        // pos.Overflow, neg.Overflow

        List<Long> firstOp = Arrays.asList(0L, 0L, 254L, 1000L, -500L, 500L, -1L,
                247L, Long.MAX_VALUE, -10L);
        List<Long> secondOp = Arrays.asList(0L, 899L, 0L, 315L, 239L, -239L, 1L,
                -247L, 10L, Long.MIN_VALUE);
        List<Long> result = Arrays.asList(0L, 899L, 254L, 1315L, -261L, 261L, 0L,
                0L, -9223372036854775799L, 9223372036854775798L);


        Object[][] data = new Object[firstOp.size()][];
        for (int i = 0; i < firstOp.size(); i++) {
            data[i] = new Object[]{firstOp.get(i), secondOp.get(i), result.get(i)};
        }
        return data;
    }

    @DataProvider(name = "DataForSubtraction")
    public static Object[][] getDataForSubtractOperation() {
        // Test cases:
        // zero/zero, pos/zero, neg/zero, zero/neg, zero/pos, pos/pos(equal),
        // pos/pos, neg/neg, pos/neg, neg/pos, neg.Overflow

        Long[] firstOp = {0L, 793L, -3822L, 0L, 0L, 832L, 275L, -389572L, 34780L,
                -872364L, Long.MIN_VALUE};
        Long[] secondOp = {0L, 0L, 0L, -476L, 126L, 832L, 75L, -528L, -13220L,
                239847L, Long.MAX_VALUE};
        Long[] result = {0L, 793L, -3822L, 476L, -126L, 0L, 200L, -389044L, 48000L,
                -1112211L, 1L};

        Object[][] data = new Object[firstOp.length][];
        for (int i = 0; i < firstOp.length; i++) {
            data[i] = new Object[]{firstOp[i], secondOp[i], result[i]};
        }
        return data;
    }

    @DataProvider(name = "DataForMultiplication")
    public static Object[][] getDataForMultiplyOperation() {

        //Test cases:
        // zero/zero,  pos/zero, neg/zero, zero/neg, zero/pos,   pos/one, neg/one,
        // one/pos, one/neg, neg/neg, pos/pos,
        // pos.Overflow, neg.Overflow

        Long[] firstOp = {0L, 793L, -3822L, 0L, 0L, 832L, -275L, 1L, 1L,
                -872364L, 235L, 92233720368547758L, Long.MIN_VALUE};
        Long[] secondOp = {0L, 0L, 0L, -476L, 126L, 1L, 1L, 528L, -13220L,
                -247L, 20L, 200L, 2L};
        Long[] result = {0L, 0L, 0L, 0L, 0L, 832L, -275L, 528L, -13220L,
                215473908L, 4700L, -16L, 0L};

        Object[][] data = new Object[firstOp.length][];
        for (int i = 0; i < firstOp.length; i++) {
            data[i] = new Object[]{firstOp[i], secondOp[i], result[i]};
        }

        return data;
    }

    @DataProvider(name = "DataForDivision")
    public static Object[][] getDataForDivOperation() {

        //Test cases:
        // zero/pos, zero/neg, pos/one, neg/one, one/pos, one/neg, pos/pos,
        // neg/neg(with reminder), pos/neg(with rem),
        // neg/pos(with rem)

        Long[] firstOp = {0L, 0L, 3822L, -476L, 1L, 1L, 275L,
                -200L, 34987L, -872364L};
        Long[] secondOp = {19438709873L, -19438709873L, 1L, 1L, 126L, -832L, 25L,
                -3L, -27L, 247L};
        Long[] result = {0L, 0L, 3822L, -476L, 0L, 0L, 11L,
                66L, -1295L, -3531L};

        Object[][] data = new Object[firstOp.length][];
        for (int i = 0; i < firstOp.length; i++) {
            data[i] = new Object[]{firstOp[i], secondOp[i], result[i]};
        }

        return data;
    }

    @DataProvider(name = "DataForDivisionDouble")
    public static Object[][] getDataForDivOperationDouble() {
        // Test cases with good results:
        // pos/neg, neg/pos, pos/pos, neg/neg,

        Double[] firstOp = {25.344, -1.44, 1.25, -0.169, 5.0};

        Double[] secondOp = {-0.256, 1.2, 0.5, -13.0, 2.5};

        Double[] result = {-99.0, -1.2, 2.5, 0.013, 2.0};

        Double[] delta = {0.1, 0.01, 0.0001, 0.00001, 0.000001};


        Object[][] data = new Object[firstOp.length][];
        for (int i = 0; i < firstOp.length; i++) {
            data[i] = new Object[]{firstOp[i], secondOp[i], result[i], delta[i]};
        }

        return data;
    }

    @DataProvider(name = "DataForZeroDivDouble")
    public static Object[][] getDataForZeroDivOperationDouble() {
        // Test cases with zero results:
        // pos/+-inf, neg/+-inf, zero/+-inf,  -zero/+-inf, min/max=0

        Double[] firstOp = {25.344, 9038.2374, -1.44, -2783.45222, 0.0, 0.0, -0.0,
                -0.0, Double.MIN_VALUE};

        Double[] secondOp = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.MAX_VALUE};

        Double[] result = {0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0};


        Object[][] data = new Object[firstOp.length][];
        for (int i = 0; i < firstOp.length; i++) {
            data[i] = new Object[]{firstOp[i], secondOp[i], result[i]};
        }

        return data;
    }


    @DataProvider(name = "DataForInfDivDouble")
    public static Object[][] getDataForInfDivOperationDouble() {
        //All double Test cases:
        // pos/zero, neg/zero, pos/-zero, neg/-zero
        // pos/+-inf, neg/+-inf, +-inf/pos, +-inf/neg, +-inf/zero,
        // zero/+-inf, +-inf/-zero, -zero/+-inf
        // NaN/+-inf,+-inf/NaN, pos/NaN, neg/NaN, NaN/pos, NaN/neg, +-zero/NaN, NaN/+-zero
        // pos/neg, neg/pos, pos/pos, neg/neg, pos.OverFlow, neg.Overflow, min/max=0

        //Test cases with infinite results:
        // INF 1. pos/zero, neg/zero, pos/-zero, neg/-zero,
        // +-inf/pos, +-inf/neg,
        // +-inf/zero,+-inf/-zero,
        // pos.OverFlow, neg.Overflow,

        Double[] firstOp = {3098.99209, -2309.22, 38.99209, -2309.20982,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.MAX_VALUE, -Double.MAX_VALUE};

        Double[] secondOp = {0.0, 0.0, -0.0, -0.0,
                34030.33, 9843.3325, -9872.254, -987982.253,
                0.0, 0.0, -0.0, -0.0,
                Double.MIN_VALUE, Double.MIN_VALUE};

        Double[] result =
                {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                        Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY,
                        Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                        Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY,
                        Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                        Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY,
                        Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};

        Object[][] data = new Object[firstOp.length][];
        for (int i = 0; i < firstOp.length; i++) {
            data[i] = new Object[]{firstOp[i], secondOp[i], result[i]};
        }

        return data;
    }

    @DataProvider(name = "DataForNaNDivDouble")
    public static Object[][] getDataForNaNDivOperationDouble() {
        //Test cases with NaN results:
        // NAN 3. NaN/+-inf, +-inf/NaN,
        // pos/NaN, neg/NaN, NaN/pos, NaN/neg,
        // +-zero/NaN, NaN/+-zero

        Double[] firstOp = {Double.NaN, Double.NaN, Double.POSITIVE_INFINITY,
                Double.NEGATIVE_INFINITY,
                3454.23467, -3874.90283480984, Double.NaN, Double.NaN,
                0.0, -0.0, Double.NaN, Double.NaN};

        Double[] secondOp = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.NaN, Double.NaN,
                Double.NaN, Double.NaN, 198753.45982714, -234987.5421,
                Double.NaN, Double.NaN, 0.0, -0.0};


        Object[][] data = new Object[firstOp.length][];
        for (int i = 0; i < firstOp.length; i++) {
            data[i] = new Object[]{firstOp[i], secondOp[i]};
        }

        return data;
    }


}
