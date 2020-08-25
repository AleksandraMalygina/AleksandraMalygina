package hw4;

import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {

    @Step("Assert that int value is correct")
    public void assertInt(int expected, int actual) {
        assertThat(expected).isEqualTo(actual);
    }

    @Step("Assert that String value is correct")
    public void assertString(String expected, String actual) {
        assertThat(expected).isEqualTo(actual);
    }

    @Step("Assert that elements of list are as expected")
    public <T> void assertList(List<T> expected, List<T> actual) {
        assertThat(expected).containsExactlyInAnyOrderElementsOf(actual);
    }

    @Step("assert that statement is True")
    public void assertTrue(boolean actual) {
        assertThat(actual).isTrue();
    }

    @Step("assert that statement is False")
    public void assertFalse(boolean actual) {
        assertThat(actual).isFalse();
    }
}
