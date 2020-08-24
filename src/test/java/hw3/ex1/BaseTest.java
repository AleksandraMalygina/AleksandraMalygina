package hw3.ex1;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {

    public void assertInt(int expected, int actual) {
        assertThat(expected).isEqualTo(actual);
    }

    public void assertString(String expected, String actual) {
        assertThat(expected).isEqualTo(actual);
    }

    public <T> void assertList(List<T> expected, List<T> actual) {
        assertThat(expected).containsExactlyInAnyOrderElementsOf(actual);
    }

    public void assertTrue(boolean actual) {
        assertThat(actual).isTrue();
    }

    public void assertFalse(boolean actual) {
        assertThat(actual).isFalse();
    }
}
