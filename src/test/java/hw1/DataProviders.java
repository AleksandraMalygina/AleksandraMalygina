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

        // {a, b, res}
        Object[][] data = { {   0L,    0L,    0L},
                            {   0L,  899L,  899L},
                            { 254L,    0L,  254L},
                            {1000L,  315L, 1315L},
                            {-500L,  239L, -261L},
                            { 500L, -239L,  261L},
                            {  -1L,    1L,    0L},
                            { 247L, -247L,    0L},
                            {Long.MAX_VALUE,       10L, -9223372036854775799L},
                            {-10L,      Long.MIN_VALUE,  9223372036854775798L} };

        return data;
    }

    @DataProvider(name = "DataForSubtraction")
    public static Object[][] getDataForSubtractOperation() {
        // Test cases:
        // zero/zero, pos/zero, neg/zero, zero/neg, zero/pos, pos/pos(equal),
        // pos/pos, neg/neg, pos/neg, neg/pos, neg.Overflow

        // {a, b, res}
        Object[][] data = { {      0L,      0L,        0L},
                            {    793L,      0L,      793L},
                            {  -3822L,      0L,    -3822L},
                            {      0L,   -476L,      476L},
                            {      0L,    126L,     -126L},
                            {    832L,    832L,        0L},
                            {    275L,     75L,      200L},
                            {-389572L,   -528L,  -389044L},
                            {  34780L, -13220L,    48000L},
                            {-872364L, 239847L, -1112211L},
                            {Long.MIN_VALUE, Long.MAX_VALUE, 1L} };

        return data;
    }

    @DataProvider(name = "DataForMultiplication")
    public static Object[][] getDataForMultiplyOperation() {

        //Test cases:
        // zero/zero,  pos/zero, neg/zero, zero/neg, zero/pos,   pos/one, neg/one,
        // one/pos, one/neg, neg/neg, pos/pos,
        // pos.Overflow, neg.Overflow

        // {a, b, res}
        Object[][] data = { {                0L,      0L,         0L},
                            {              793L,      0L,         0L},
                            {            -3822L,      0L,         0L},
                            {                0L,   -476L,         0L},
                            {                0L,    126L,         0L},
                            {              832L,      1L,       832L},
                            {             -275L,      1L,      -275L},
                            {                1L,    528L,       528L},
                            {                1L, -13220L,    -13220L},
                            {          -872364L,   -247L, 215473908L},
                            {              235L,     20L,      4700L},
                            {92233720368547758L,    200L,       -16L},
                            {    Long.MIN_VALUE,      2L,         0L} };

        return data;
    }

    @DataProvider(name = "DataForDivision")
    public static Object[][] getDataForDivOperation() {

        //Test cases:
        // zero/pos, zero/neg, pos/one, neg/one, one/pos, one/neg, pos/pos,
        // neg/neg(with reminder), pos/neg(with rem),
        // neg/pos(with rem)

        // {a, b, res}
        Object[][] data = { {      0L, 19438709873L,     0L},
                            {      0L,-19438709873L,     0L},
                            {   3822L,           1L,  3822L},
                            {   -476L,           1L,  -476L},
                            {      1L,         126L,     0L},
                            {      1L,        -832L,     0L},
                            {    275L,          25L,    11L},
                            {   -200L,          -3L,    66L},
                            {  34987L,         -27L, -1295L},
                            {-872364L,         247L, -3531L} };

        return data;
    }

    @DataProvider(name = "DataForDivisionDouble")
    public static Object[][] getDataForDivOperationDouble() {
        // Test cases with good results:
        // pos/neg, neg/pos, pos/pos, neg/neg,

        // {a, b, res, delta}
        Object[][] data = { {25.344, -0.256,  -99.0,      0.1},
                            { -1.44,    1.2,   -1.2,     0.01},
                            {  1.25,    0.5,    2.5,   0.0001},
                            {-0.169,  -13.0,  0.013,  0.00001},
                            {   5.0,    2.5,    2.0, 0.000001} };

        return data;
    }

    @DataProvider(name = "DataForZeroDivDouble")
    public static Object[][] getDataForZeroDivOperationDouble() {
        // Test cases with zero results:
        // pos/+-inf, neg/+-inf, zero/+-inf,  -zero/+-inf, min/max=0

        // {a, b, res}
        Object[][] data = { {     25.344, Double.POSITIVE_INFINITY,  0.0},
                            {  9038.2374, Double.NEGATIVE_INFINITY, -0.0},
                            {      -1.44, Double.POSITIVE_INFINITY, -0.0},
                            {-2783.45222, Double.NEGATIVE_INFINITY,  0.0},
                            {        0.0, Double.POSITIVE_INFINITY,  0.0},
                            {        0.0, Double.NEGATIVE_INFINITY, -0.0},
                            {       -0.0, Double.POSITIVE_INFINITY, -0.0},
                            {       -0.0, Double.NEGATIVE_INFINITY,  0.0},
                            { Double.MIN_VALUE,   Double.MAX_VALUE,  0.0} };

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

        // {a, b, res}
        Object[][] data = { {3098.99209,                0.0, Double.POSITIVE_INFINITY},
                {                -2309.22,              0.0, Double.NEGATIVE_INFINITY},
                {                38.99209,             -0.0, Double.NEGATIVE_INFINITY},
                {             -2309.20982,             -0.0, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY,         34030.33, Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY,        9843.3325, Double.NEGATIVE_INFINITY},
                {Double.POSITIVE_INFINITY,        -9872.254, Double.NEGATIVE_INFINITY},
                {Double.NEGATIVE_INFINITY,      -987982.253, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY,              0.0, Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY,              0.0, Double.NEGATIVE_INFINITY},
                {Double.POSITIVE_INFINITY,             -0.0, Double.NEGATIVE_INFINITY},
                {Double.NEGATIVE_INFINITY,             -0.0, Double.POSITIVE_INFINITY},
                {        Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY},
                {       -Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY}};

        return data;
    }

    @DataProvider(name = "DataForNaNDivDouble")
    public static Object[][] getDataForNaNDivOperationDouble() {
        //Test cases with NaN results:
        // NAN 3. NaN/+-inf, +-inf/NaN,
        // pos/NaN, neg/NaN, NaN/pos, NaN/neg,
        // +-zero/NaN, NaN/+-zero

        // {a, b, res}
        Object[][] data = { {              Double.NaN, Double.POSITIVE_INFINITY},
                            {              Double.NaN, Double.NEGATIVE_INFINITY},
                            {Double.POSITIVE_INFINITY,               Double.NaN},
                            {Double.NEGATIVE_INFINITY,               Double.NaN},
                            {              3454.23467,               Double.NaN},
                            {       -3874.90283480984,               Double.NaN},
                            {              Double.NaN,          198753.45982714},
                            {              Double.NaN,             -234987.5421},
                            {                     0.0,               Double.NaN},
                            {                    -0.0,               Double.NaN},
                            {              Double.NaN,                      0.0},
                            {              Double.NaN,                     -0.0} };

        return data;
    }


}
